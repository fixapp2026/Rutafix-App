package com.main.admin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rutafix.R
import kotlin.jvm.java

class PerfilTecnicoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_tecnico)

        val btnVolver = findViewById<ImageButton>(R.id.btnVolverListaTecnicos)
        val btnHistorial = findViewById<Button>(R.id.btnVerHistorialServicios)
        val tvNombre = findViewById<TextView>(R.id.tvNombrePerfilTecnico)

        // Recibimos el nombre del técnico desde la lista
        val nombreTecnico = intent.getStringExtra("NOMBRE_TECNICO") ?: "Juan Pérez"
        tvNombre.text = nombreTecnico

        btnVolver.setOnClickListener { finish() }

        btnHistorial.setOnClickListener {
            val intent = Intent(this, HistorialTecnicoActivity::class.java)
            startActivity(intent)
        }
    }
}