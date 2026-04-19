package com.example.rutafix

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.rutafix.supabase.SupabaseConfig
import com.google.android.material.textfield.TextInputEditText
import com.main.MainActivity
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.coroutines.launch

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
                Toast.makeText(this@Login, "¡Bienvenido de nuevo!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@Login, MainActivity::class.java))
                finish()
            } catch (e: Exception) {
                Toast.makeText(this@Login, "Credenciales incorrectas o el usuario no existe", Toast.LENGTH_LONG).show()
            }
        }
    }
}