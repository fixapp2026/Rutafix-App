package com.main.home

import android.R

data class Grua(
    val id: Int,
    val tipo: String,
    val capacidad: String,
    val tiempoEstimado: String,
    val precio: String,
    val imagenResId: Int,
    val descripcion: String
)

object ProveedorGruas {
    fun obtenerGruas(): List<Grua> {
        return listOf(
            Grua(
                id = 1,
                tipo = "Grúa de Plataforma",
                capacidad = "Hasta 3 toneladas",
                tiempoEstimado = "15 - 20 min",
                precio = "80.000 COP",
                imagenResId = android.R.drawable.ic_menu_directions,
                descripcion = "Ideal para vehículos livianos y sedanes. Transporte seguro sin rodamiento."
            ),
            Grua(
                id = 2,
                tipo = "Grúa de Gancho",
                capacidad = "Hasta 5 toneladas",
                tiempoEstimado = "25 - 30 min",
                precio = "120.000 COP",
                imagenResId = android.R.drawable.ic_menu_directions,
                descripcion = "Para camionetas y vehículos medianos. Resistente para rescates en zanjas."
            ),
            Grua(
                id = 3,
                tipo = "Grúa Pesada",
                capacidad = "Hasta 10 toneladas",
                tiempoEstimado = "40 - 50 min",
                precio = "250.000 COP",
                imagenResId = android.R.drawable.ic_menu_directions,
                descripcion = "Especializada para camiones y buses pequeños. Equipo reforzado."
            )
        )
    }
}