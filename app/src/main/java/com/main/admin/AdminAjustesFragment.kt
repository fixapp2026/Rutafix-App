package com.main.admin

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.rutafix.Login
import com.example.rutafix.R
import com.example.rutafix.supabase.SupabaseConfig
import io.github.jan.supabase.auth.auth
import kotlinx.coroutines.launch

class AdminAjustesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_admin_ajustes, container, false)

        // Usamos los IDs exactos de tu nuevo XML
        val btnCerrarSesion = view.findViewById<Button>(R.id.btn_logout_perfil)
        val btnEditarPerfil = view.findViewById<Button>(R.id.btn_go_edit_profile)

        // Acción: Editar Perfil
        btnEditarPerfil.setOnClickListener {
            val intent = Intent(requireContext(), AdminEditarPerfilActivity::class.java)
            startActivity(intent)
        }

        // Acción: Botón de Salir (Muestra el diálogo primero)
        btnCerrarSesion.setOnClickListener {
            mostrarDialogoDeSalida()
        }

        return view
    }

    private fun mostrarDialogoDeSalida() {
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.logout_dialog_title)) // "Cerrar sesión"
            .setMessage(getString(R.string.logout_dialog_message)) // "¿Seguro que deseas salir...?"
            .setPositiveButton(getString(R.string.logout_dialog_btn_confirm)) { _, _ ->
                cerrarSesion()
            }
            .setNegativeButton(getString(R.string.logout_dialog_btn_cancel), null)
            .show()
    }

    private fun cerrarSesion() {
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                SupabaseConfig.client.auth.signOut()
                Toast.makeText(requireContext(), "Sesión cerrada correctamente", Toast.LENGTH_SHORT).show()
                val intent = Intent(requireContext(), Login::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error al cerrar sesión", Toast.LENGTH_SHORT).show()
            }
        }
    }
}