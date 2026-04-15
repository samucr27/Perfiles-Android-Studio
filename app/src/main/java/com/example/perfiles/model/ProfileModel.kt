package com.example.perfiles.model

data class Profile(
    val nombre: String,
    val programa: String,
    val semestre: String,
    val descripcion: String,
    val edad: Int,
    val ciudad: String,
    val correo: String,
    val hobbies: List<String>,
    val pasatiempos: List<String>,
    val deportes: List<String>,
    val intereses: List<String>,
    val imagenUrl: String
)