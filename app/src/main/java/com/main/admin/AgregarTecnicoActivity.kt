package com.main.admin

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rutafix.R

class AgregarTecnicoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_tecnico)

        val btnVolver = findViewById<ImageButton>(R.id.btnVolverTecnicos)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarTecnico)

        btnVolver.setOnClickListener {
            finish()
        }

        btnGuardar.setOnClickListener {
            Toast.makeText(this, "¡Técnico guardado exitosamente!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}