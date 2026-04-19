package com.example.rutafix

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_password)

        val etEmail = findViewById<TextInputEditText>(R.id.et_forgot_email)
        val btnSend = findViewById<Button>(R.id.btn_send_recovery)
        val tvBack = findViewById<android.widget.TextView>(R.id.tv_back_to_login)

        btnSend.setOnClickListener {
            val email = etEmail.text.toString().trim()
            if (email.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa tu correo electrónico", Toast.LENGTH_SHORT).show()
            } else {
                // Aquí iría la lógica para enviar el correo de recuperación
                Toast.makeText(this, "Instrucciones enviadas a $email", Toast.LENGTH_LONG).show()
                finish()
            }
        }

        tvBack.setOnClickListener {
            finish()
        }
    }
}