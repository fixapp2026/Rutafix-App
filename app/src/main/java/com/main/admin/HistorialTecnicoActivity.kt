package com.main.admin

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rutafix.R

class HistorialTecnicoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial_tecnico)

        val btnVolver = findViewById<ImageButton>(R.id.btnVolverPerfilTecnico)
        val recyclerHistorial = findViewById<RecyclerView>(R.id.recyclerHistorialTecnico)

        btnVolver.setOnClickListener { finish() }

        // ¡Reutilizamos tu adaptador de reportes con datos falsos!
        val historialDePrueba = listOf(
            ReporteDummy("Mantenimiento Preventivo", "12 Oct 2026", "Empresas Norte", "Completado", "85.000 COP"),
            ReporteDummy("Revisión Eléctrica", "10 Oct 2026", "Pedro Silva", "Cancelado", "0 COP"),
            ReporteDummy("Instalación de Batería", "05 Oct 2026", "María López", "Completado", "120.000 COP")
        )

        recyclerHistorial.layoutManager = LinearLayoutManager(this)
        recyclerHistorial.adapter = ReportesAdapter(historialDePrueba)
    }
}