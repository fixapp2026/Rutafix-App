package com.main.admin

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rutafix.R

class AdminEditarPerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_editar_perfil)

        val btnVolver = findViewById<ImageButton>(R.id.btnVolverAjustes)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarPerfil)

        btnVolver.setOnClickListener {
            finish()
        }

        btnGuardar.setOnClickListener {
            Toast.makeText(this, getString(R.string.perfil_actualizado_exito), Toast.LENGTH_SHORT).show()
            finish() // Cierra la pantalla simulando que guardó
        }
    }
}