package com.main.admin

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rutafix.R

class DetalleReporteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_reporte)

        val btnVolver = findViewById<ImageButton>(R.id.btnVolverReportes)
        val btnContactar = findViewById<Button>(R.id.btnContactarCliente)
        val btnCerrarServicio = findViewById<Button>(R.id.btnCerrarServicio)

        btnVolver.setOnClickListener {
            finish()
        }

        btnContactar.setOnClickListener {
            Toast.makeText(this, "Abriendo chat con el cliente...", Toast.LENGTH_SHORT).show()
        }

        btnCerrarServicio.setOnClickListener {
            Toast.makeText(this, "Servicio finalizado en la base de datos.", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}