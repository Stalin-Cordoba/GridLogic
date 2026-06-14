package com.example.gridlogicprototipo.ui.repository

import com.example.gridlogicprototipo.ui.model.Ejercicio
import com.example.gridlogicprototipo.ui.model.Figura
import com.example.gridlogicprototipo.ui.model.Opcion

class GridLogicRepository {

    fun obtenerEjercicio(id: Int): Ejercicio {
        return when (id) {
            1 -> Ejercicio(
                id = 1, titulo = "Ejercicio 1",
                matriz = listOf(
                    listOf(Figura.CUADRADO, Figura.CUADRADO, Figura.CUADRADO),
                    listOf(Figura.CIRCULO, Figura.CIRCULO, Figura.CIRCULO),
                    listOf(Figura.TRIANGULO, Figura.TRIANGULO, null)
                ),
                opciones = listOf(
                    Opcion(1, Figura.CUADRADO, "A"),
                    Opcion(2, Figura.CIRCULO, "B"),
                    Opcion(3, Figura.TRIANGULO, "C"),
                    Opcion(4, Figura.ESTRELLA, "D"),
                    Opcion(5, Figura.DIAMANTE, "E"),
                    Opcion(6, Figura.HEXAGONO, "F")
                ), respuestaCorrectaId = 3
            )
            2 -> Ejercicio(
                id = 2, titulo = "Ejercicio 2",
                matriz = listOf(
                    listOf(Figura.CUADRADO, Figura.CIRCULO, Figura.TRIANGULO),
                    listOf(Figura.CIRCULO, Figura.TRIANGULO, Figura.CUADRADO),
                    listOf(Figura.TRIANGULO, Figura.CUADRADO, null)
                ),
                opciones = listOf(
                    Opcion(1, Figura.CUADRADO, "A"),
                    Opcion(2, Figura.CIRCULO, "B"),
                    Opcion(3, Figura.TRIANGULO, "C"),
                    Opcion(4, Figura.ESTRELLA, "D"),
                    Opcion(5, Figura.DIAMANTE, "E"),
                    Opcion(6, Figura.HEXAGONO, "F")
                ), respuestaCorrectaId = 2
            )
            3 -> Ejercicio(
                id = 3, titulo = "Ejercicio 3",
                matriz = listOf(
                    listOf(Figura.CRUZ, Figura.LUNA, Figura.RAYO),
                    listOf(Figura.LUNA, Figura.RAYO, Figura.CRUZ),
                    listOf(Figura.RAYO, Figura.CRUZ, null)
                ),
                opciones = listOf(
                    Opcion(1, Figura.DIAMANTE, "A"),
                    Opcion(2, Figura.RAYO, "B"),
                    Opcion(3, Figura.LUNA, "C"),
                    Opcion(4, Figura.HEXAGONO, "D"),
                    Opcion(5, Figura.CRUZ, "E"),
                    Opcion(6, Figura.ESTRELLA, "F")
                ), respuestaCorrectaId = 3
            )
            4 -> Ejercicio(
                id = 4, titulo = "Ejercicio 4",
                matriz = listOf(
                    listOf(Figura.ESTRELLA, Figura.DIAMANTE, Figura.HEXAGONO),
                    listOf(Figura.HEXAGONO, Figura.ESTRELLA, Figura.DIAMANTE),
                    listOf(Figura.DIAMANTE, Figura.HEXAGONO, null)
                ),
                opciones = listOf(
                    Opcion(1, Figura.ESTRELLA, "A"),
                    Opcion(2, Figura.CUADRADO, "B"),
                    Opcion(3, Figura.CIRCULO, "C"),
                    Opcion(4, Figura.DIAMANTE, "D"),
                    Opcion(5, Figura.CRUZ, "E"),
                    Opcion(6, Figura.HEXAGONO, "F")
                ), respuestaCorrectaId = 1
            )
            5 -> Ejercicio(
                id = 5, titulo = "Ejercicio 5",
                matriz = listOf(
                    listOf(Figura.DIAMANTE, Figura.CRUZ, Figura.HEXAGONO),
                    listOf(Figura.CRUZ, Figura.HEXAGONO, Figura.DIAMANTE),
                    listOf(Figura.HEXAGONO, Figura.DIAMANTE, null)
                ),
                opciones = listOf(
                    Opcion(1, Figura.CIRCULO, "A"),
                    Opcion(2, Figura.RAYO, "B"),
                    Opcion(3, Figura.CRUZ, "C"),
                    Opcion(4, Figura.DIAMANTE, "D"),
                    Opcion(5, Figura.ESTRELLA, "E"),
                    Opcion(6, Figura.LUNA, "F")
                ), respuestaCorrectaId = 3
            )
            else -> throw IllegalArgumentException("Ejercicio no encontrado")
        }
    }
}