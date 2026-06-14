package com.example.gridlogicprototipo.ui.model

enum class Figura {
    CUADRADO, CIRCULO, TRIANGULO, ESTRELLA, DIAMANTE, HEXAGONO, CRUZ, LUNA, RAYO
}

data class Opcion(
    val id: Int,
    val tipoFigura: Figura,
    val etiqueta: String
)

data class Ejercicio(
    val id: Int,
    val titulo: String,
    val matriz: List<List<Figura?>>,
    val opciones: List<Opcion>,
    val respuestaCorrectaId: Int
)