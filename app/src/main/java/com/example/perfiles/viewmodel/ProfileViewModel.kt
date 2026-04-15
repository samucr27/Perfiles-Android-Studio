package com.example.perfiles.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.perfiles.model.Profile

class ProfileViewModel : ViewModel() {
    var profile by mutableStateOf(
        Profile(
            nombre = "Samuel Castellanos Rivera",
            programa = "Ingeniería de Software",
            semestre = "5°",
            descripcion = "Estudiante apasionado por la tecnología y el desarrollo de apps moviles",
            edad = 19,
            ciudad = "Bogotá",
            correo = "samuelcastellanos@ucundinamarca.edu.co",
            hobbies = listOf("Programar", "Música", "Viajar"),
            pasatiempos = listOf("Videojuegos", "Peliculas"),
            deportes = listOf("Fútbol", "Baloncesto"),
            intereses = listOf("IA", "Desarrollo Móvil"),
            imagenUrl = "https://docs.google.com/uc?id=1SrXYdd6DMY4itxuIi8bGBawHV6Yu7_Di"
        )
    )

    var mostrarDetalles by mutableStateOf(false)
        private set

    fun toggleDetalles() {
        mostrarDetalles = !mostrarDetalles
    }
}