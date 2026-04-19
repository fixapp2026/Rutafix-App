package com.example.rutafix

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.rutafix.models.Usuario
import com.example.rutafix.supabase.SupabaseConfig
import com.google.android.material.textfield.TextInputEditText
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch

class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        val etName = findViewById<TextInputEditText>(R.id.et_name)
        val etLastname = findViewById<TextInputEditText>(R.id.et_lastname)
        val etEmail = findViewById<TextInputEditText>(R.id.et_reg_email)
        val etPass = findViewById<TextInputEditText>(R.id.et_reg_password)
        val etConfirmPass = findViewById<TextInputEditText>(R.id.et_confirm_password)
        val checkTerminos = findViewById<CheckBox>(R.id.checkTerminos)
        val btnRegistrar = findViewById<Button>(R.id.btn_register)
        val btnBack = findViewById<LinearLayout>(R.id.btnBackToLogin)

        btnBack.setOnClickListener { finish() }

        btnRegistrar.setOnClickListener {
            val nombre = etName.text.toString().trim()
            val apellido = etLastname.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val pass = etPass.text.toString().trim()
            val confirmPass = etConfirmPass.text.toString().trim()

            if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pass != confirmPass) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pass.length < 6) {
                Toast.makeText(this, "Mínimo 6 caracteres", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!checkTerminos.isChecked) {
                Toast.makeText(this, "Acepta los términos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            registrarUsuario(nombre, apellido, email, pass)
        }
    }

    private fun registrarUsuario(nombre: String, apellido: String, email: String, pass: String) {
        lifecycleScope.launch {
            try {
                val userInfo = SupabaseConfig.client.auth.signUpWith(Email) {
                    this.email = email
                    this.password = pass
                }

                val userId = userInfo?.id ?: SupabaseConfig.client.auth.currentUserOrNull()?.id

                if (userId != null) {
                    try {
                        val nuevoUsuario = Usuario(
                            id = userId,
                            nombres = nombre,
                            apellidos = apellido,
                            correo = email,
                            rol = "usuario"
                        )
                        // IMPORTANTE: "Usuarios" con U mayúscula como en tu base de datos
                        SupabaseConfig.client.postgrest["Usuarios"].insert(nuevoUsuario)
                        Toast.makeText(this@Registro, "¡Registro completado!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@Registro, Login::class.java))
                        finish()
                    } catch (dbError: Exception) {
                        Toast.makeText(this@Registro, "Error al guardar datos: ${dbError.message}", Toast.LENGTH_LONG).show()
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(this@Registro, "Error: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
            }
        }
    }
}