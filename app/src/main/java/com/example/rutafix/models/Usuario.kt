package com.example.rutafix.models

import kotlinx.serialization.Serializable

@Serializable
data class Usuario(
    val id: String,
    val nombres: String,
    val apellidos: String,
    val rol: String
)