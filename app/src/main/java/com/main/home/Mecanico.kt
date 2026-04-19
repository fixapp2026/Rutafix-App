package com.main.home

import com.example.rutafix.R

data class Mecanico(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val precio: String,
    val imagenResId: Int
)

object ProveedorMecanicos {
    fun obtenerMecanicos(): List<Mecanico> {
        return listOf(
            Mecanico(1, "Pedro Alcázar", "Experto en motores y frenos. 10 años de experiencia.", "45.000 COP", R.drawable.perfil),
            Mecanico(2, "Juan Martínez", "Especialista en sistemas eléctricos y escaneo.", "55.000 COP", R.drawable.perfil),
            Mecanico(3, "Roberto Gómez", "Mecánica general y cambio de fluidos.", "40.000 COP", R.drawable.perfil),
            Mecanico(4, "Carlos Ruiz", "Experto en suspensión y dirección.", "50.000 COP", R.drawable.perfil)
        )
    }
}