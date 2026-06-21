package com.example.gridlogicprototipo.ui.model

enum class Dificultad {
    FACIL, INTERMEDIO, DIFICIL
}

data class Opcion(
    val id: Int,
    val imagenResId: Int,
    val etiqueta: String
)

data class Ejercicio(
    val id: Int,
    val dificultad: Dificultad,
    val imagenMatrizResId: Int,
    val opciones: List<Opcion>,
    val respuestaCorrectaId: Int
)