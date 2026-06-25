package com.example.gridlogicprototipo.ui.repository

import com.example.gridlogicprototipo.R
import com.example.gridlogicprototipo.ui.model.Dificultad
import com.example.gridlogicprototipo.ui.model.Ejercicio
import com.example.gridlogicprototipo.ui.model.Opcion

class GridLogicRepository {

    fun generarTestAleatorio(): List<Ejercicio> {
        val seleccionFacil = ejerciciosFaciles.shuffled().take(3)
        val seleccionIntermedio = ejerciciosIntermedios.shuffled().take(4)
        val seleccionDificil = ejerciciosDificiles.shuffled().take(3)

        return seleccionFacil + seleccionIntermedio + seleccionDificil
    }

    private fun crearEjercicio(
        id: Int,
        dificultad: Dificultad,
        imagenMatrizResId: Int,
        opciones: List<Opcion>,
        respuestaCorrectaId: Int
    ): Ejercicio {
        return Ejercicio(
            id = id,
            dificultad = dificultad,
            imagenMatrizResId = imagenMatrizResId,
            opciones = opciones,
            respuestaCorrectaId = respuestaCorrectaId
        )
    }

    private val ejerciciosFaciles = listOf(

        crearEjercicio(
            id = 1,
            dificultad = Dificultad.FACIL,
            imagenMatrizResId = R.drawable.matriz_facil_1,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_f1_a, "1"),
                Opcion(2, R.drawable.opcion_f1_b, "2"),
                Opcion(3, R.drawable.opcion_f1_c, "3"),
                Opcion(4, R.drawable.opcion_f1_d, "4"),
                Opcion(5, R.drawable.opcion_f1_e, "5"),
                Opcion(6, R.drawable.opcion_f1_f, "6")
            ),
            respuestaCorrectaId = 4
        ),

        crearEjercicio(
            id = 2,
            dificultad = Dificultad.FACIL,
            imagenMatrizResId = R.drawable.matriz_facil_2,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_f2_a, "1"),
                Opcion(2, R.drawable.opcion_f2_b, "2"),
                Opcion(3, R.drawable.opcion_f2_c, "3"),
                Opcion(4, R.drawable.opcion_f2_d, "4"),
                Opcion(5, R.drawable.opcion_f2_e, "5"),
                Opcion(6, R.drawable.opcion_f2_f, "6")
            ),
            respuestaCorrectaId = 3
        ),

        crearEjercicio(
            id = 3,
            dificultad = Dificultad.FACIL,
            imagenMatrizResId = R.drawable.matriz_facil_3,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_f3_a, "1"),
                Opcion(2, R.drawable.opcion_f3_b, "2"),
                Opcion(3, R.drawable.opcion_f3_c, "3"),
                Opcion(4, R.drawable.opcion_f3_d, "4"),
                Opcion(5, R.drawable.opcion_f3_e, "5"),
                Opcion(6, R.drawable.opcion_f3_f, "6")
            ),
            respuestaCorrectaId = 1
        ),


    )

    private val ejerciciosIntermedios = listOf(

        crearEjercicio(
            id = 10,
            dificultad = Dificultad.INTERMEDIO,
            imagenMatrizResId = R.drawable.matriz_intermedia_1,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_i1_a, "1"),
                Opcion(2, R.drawable.opcion_i1_b, "2"),
                Opcion(3, R.drawable.opcion_i1_c, "3"),
                Opcion(4, R.drawable.opcion_i1_d, "4"),
                Opcion(5, R.drawable.opcion_i1_e, "5"),
                Opcion(6, R.drawable.opcion_i1_f, "6")
            ),
            respuestaCorrectaId = 3
        ),

        crearEjercicio(
            id = 11,
            dificultad = Dificultad.INTERMEDIO,
            imagenMatrizResId = R.drawable.matriz_intermedia_2,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_i2_a, "1"),
                Opcion(2, R.drawable.opcion_i2_b, "2"),
                Opcion(3, R.drawable.opcion_i2_c, "3"),
                Opcion(4, R.drawable.opcion_i2_d, "4"),
                Opcion(5, R.drawable.opcion_i2_e, "5"),
                Opcion(6, R.drawable.opcion_i2_f, "6")
            ),
            respuestaCorrectaId = 5
        ),

        crearEjercicio(
            id = 12,
            dificultad = Dificultad.INTERMEDIO,
            imagenMatrizResId = R.drawable.matriz_intermedia_3,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_i3_a, "1"),
                Opcion(2, R.drawable.opcion_i3_b, "2"),
                Opcion(3, R.drawable.opcion_i3_c, "3"),
                Opcion(4, R.drawable.opcion_i3_d, "4"),
                Opcion(5, R.drawable.opcion_i3_e, "5"),
                Opcion(6, R.drawable.opcion_i3_f, "6"),
                Opcion(7, R.drawable.opcion_i3_g, "7"),
                Opcion(8, R.drawable.opcion_i3_h, "8")
            ),
            respuestaCorrectaId = 8
        ),

        crearEjercicio(
            id = 13,
            dificultad = Dificultad.INTERMEDIO,
            imagenMatrizResId = R.drawable.matriz_intermedia_4,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_i4_a, "1"),
                Opcion(2, R.drawable.opcion_i4_b, "2"),
                Opcion(3, R.drawable.opcion_i4_c, "3"),
                Opcion(4, R.drawable.opcion_i4_d, "4"),
                Opcion(5, R.drawable.opcion_i4_e, "5"),
                Opcion(6, R.drawable.opcion_i4_f, "6"),
                Opcion(7, R.drawable.opcion_i4_g, "7"),
                Opcion(8, R.drawable.opcion_i4_h, "8")
            ),
            respuestaCorrectaId = 3
        ),


    )

    private val ejerciciosDificiles = listOf(

        crearEjercicio(
            id = 22,
            dificultad = Dificultad.DIFICIL,
            imagenMatrizResId = R.drawable.matriz_dificil_1,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_d1_a, "1"),
                Opcion(2, R.drawable.opcion_d1_b, "2"),
                Opcion(3, R.drawable.opcion_d1_c, "3"),
                Opcion(4, R.drawable.opcion_d1_d, "4"),
                Opcion(5, R.drawable.opcion_d1_e, "5"),
                Opcion(6, R.drawable.opcion_d1_f, "6"),
                Opcion(7, R.drawable.opcion_d1_g, "7"),
                Opcion(8, R.drawable.opcion_d1_h, "8")
            ),
            respuestaCorrectaId = 5
        ),

        crearEjercicio(
            id = 23,
            dificultad = Dificultad.DIFICIL,
            imagenMatrizResId = R.drawable.matriz_dificil_2,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_d2_a, "1"),
                Opcion(2, R.drawable.opcion_d2_b, "2"),
                Opcion(3, R.drawable.opcion_d2_c, "3"),
                Opcion(4, R.drawable.opcion_d2_d, "4"),
                Opcion(5, R.drawable.opcion_d2_e, "5"),
                Opcion(6, R.drawable.opcion_d2_f, "6"),
                Opcion(7, R.drawable.opcion_d2_g, "7"),
                Opcion(8, R.drawable.opcion_d2_h, "8")
            ),
            respuestaCorrectaId = 7
        ),

        crearEjercicio(
            id = 24,
            dificultad = Dificultad.DIFICIL,
            imagenMatrizResId = R.drawable.matriz_dificil_3,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_d3_a, "1"),
                Opcion(2, R.drawable.opcion_d3_b, "2"),
                Opcion(3, R.drawable.opcion_d3_c, "3"),
                Opcion(4, R.drawable.opcion_d3_d, "4"),
                Opcion(5, R.drawable.opcion_d3_e, "5"),
                Opcion(6, R.drawable.opcion_d3_f, "6"),
                Opcion(7, R.drawable.opcion_d3_g, "7"),
                Opcion(8, R.drawable.opcion_d3_h, "8")
            ),
            respuestaCorrectaId = 1
        ),
    )
}