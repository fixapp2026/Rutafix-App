package com.example.rutafix

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.rutafix.models.Usuario
import com.example.rutafix.supabase.SupabaseConfig
import com.google.android.material.textfield.TextInputEditText
import com.inicio.Home
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch
import com.main.admin.AdminActivity
import kotlin.jvm.java


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val editEmail = findViewById<TextInputEditText>(R.id.et_email)
        val editPass = findViewById<TextInputEditText>(R.id.et_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val tvGoRegister = findViewById<TextView>(R.id.tv_go_register)
        val tvForgotPassword = findViewById<TextView>(R.id.tv_forgot_password)

        btnLogin.setOnClickListener {
            val email = editEmail.text.toString().trim()
            val pass = editPass.text.toString().trim()

            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa correo y contraseña", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            loginUsuario(email, pass)
        }

        tvGoRegister.setOnClickListener {
            startActivity(Intent(this, Registro::class.java))
        }

        tvForgotPassword.setOnClickListener {
            // Conectar con la pantalla de Recuperar Contraseña
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }

    private fun loginUsuario(email: String, pass: String) {
        lifecycleScope.launch {
            try {
                SupabaseConfig.client.auth.signInWith(Email) {
                    this.email = email
                    this.password = pass
                }

                val userId = SupabaseConfig.client.auth.currentUserOrNull()?.id

                if (userId != null) {
                    Toast.makeText(this@Login, "¡Autenticado! Verificando permisos...", Toast.LENGTH_SHORT).show()
                    // llamamos a la función que revisa si es Admin o Usuario
                    validarRolYRedirigir(userId)
                }

            } catch (e: Exception) {
                Toast.makeText(this@Login, "Credenciales incorrectas o el usuario no existe", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun validarRolYRedirigir(userId: String) {
        lifecycleScope.launch {
            try {
                // Consultamos la tabla Usuarios para traer el perfil completo
                val usuarioBD = SupabaseConfig.client.postgrest["Usuarios"]
                    .select { filter { eq("id", userId) } }
                    .decodeSingle<Usuario>()

                // Redirigimos según el rol
                if (usuarioBD.rol == "admin") {
                    val intent = Intent(this@Login, AdminActivity::class.java) // <- Nueva Activity
                    startActivity(intent)
                } else {
                    val intent = Intent(this@Login, Home::class.java) // <- Tu Activity actual de usuarios
                    startActivity(intent)
                }
                finish()

            } catch (e: Exception) {
                Toast.makeText(this@Login, getString(R.string.error_datos), Toast.LENGTH_SHORT).show()
            }
        }
    }
}