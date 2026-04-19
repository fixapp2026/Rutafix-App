package com.main.perfil

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.rutafix.R
import com.example.rutafix.models.Usuario
import com.example.rutafix.supabase.SupabaseConfig
import com.google.android.material.textfield.TextInputEditText
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.launch

class EditProfileFragment : Fragment() {

    private lateinit var etName: TextInputEditText
    private lateinit var etLastname: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPass: TextInputEditText
    private lateinit var etConfirmPass: TextInputEditText
    private lateinit var btnSave: Button
    private lateinit var tvCancel: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit_profile, container, false)

        etName = view.findViewById(R.id.et_edit_name)
        etLastname = view.findViewById(R.id.et_edit_lastname)
        etEmail = view.findViewById(R.id.et_edit_email)
        etPass = view.findViewById(R.id.et_edit_password)
        etConfirmPass = view.findViewById(R.id.et_edit_confirm_password)
        btnSave = view.findViewById(R.id.btn_save_profile)
        tvCancel = view.findViewById(R.id.tv_cancel_edit)

        cargarDatosUsuario()

        btnSave.setOnClickListener {
            validarYActualizar()
        }

        tvCancel.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }

    private fun cargarDatosUsuario() {
        val user = SupabaseConfig.client.auth.currentUserOrNull() ?: return
        etEmail.setText(user.email)

        lifecycleScope.launch {
            try {
                val usuarioData = SupabaseConfig.client.postgrest["usuarios"]
                    .select(columns = Columns.ALL) {
                        filter { eq("id", user.id) }
                    }.decodeSingle<Usuario>()

                etName.setText(usuarioData.nombres)
                etLastname.setText(usuarioData.apellidos)
            } catch (e: Exception) {
                Log.e("EditProfile", "Error carga: ${e.message}")
            }
        }
    }

    private fun validarYActualizar() {
        val nombres = etName.text.toString().trim()
        val apellidos = etLastname.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val pass = etPass.text.toString().trim()
        val confirmPass = etConfirmPass.text.toString().trim()

        if (nombres.isEmpty() || apellidos.isEmpty() || email.isEmpty()) {
            Toast.makeText(context, "Campos obligatorios vacíos", Toast.LENGTH_SHORT).show()
            return
        }

        if (pass.isNotEmpty()) {
            if (pass.length < 6) {
                Toast.makeText(context, "Mínimo 6 caracteres", Toast.LENGTH_SHORT).show()
                return
            }
            if (pass != confirmPass) {
                Toast.makeText(context, "Las claves no coinciden", Toast.LENGTH_SHORT).show()
                return
            }
        }

        actualizarPerfil(nombres, apellidos, email, pass)
    }

    private fun actualizarPerfil(nombres: String, apellidos: String, email: String, pass: String) {
        val userId = SupabaseConfig.client.auth.currentUserOrNull()?.id ?: return
        
        lifecycleScope.launch {
            try {
                SupabaseConfig.client.postgrest["usuarios"].update({
                    set("nombres", nombres)
                    set("apellidos", apellidos)
                }) {
                    filter { eq("id", userId) }
                }

                SupabaseConfig.client.auth.updateUser {
                    this.email = email
                    if (pass.isNotEmpty()) this.password = pass
                }

                Toast.makeText(context, "Perfil actualizado con éxito", Toast.LENGTH_LONG).show()
                parentFragmentManager.popBackStack()

            } catch (e: Exception) {
                Toast.makeText(context, "Error: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
            }
        }
    }
}