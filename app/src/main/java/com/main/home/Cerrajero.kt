package com.main.home

import com.example.rutafix.R

data class Cerrajero(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val precio: String,
    val imagenResId: Int
)

object ProveedorCerrajeros {
    fun obtenerCerrajeros(): List<Cerrajero> {
        return listOf(
            Cerrajero(1, "Marcos Llaves", "Especialista en apertura de puertas sin daño. 24/7.", "35.000 COP", R.drawable.perfil),
            Cerrajero(2, "Luis Seguridad", "Duplicado de llaves con chip y apertura de baúles.", "50.000 COP", R.drawable.perfil),
            Cerrajero(3, "Andrés Cerrajería", "Apertura técnica de vehículos de alta gama.", "60.000 COP", R.drawable.perfil)
        )
    }
}