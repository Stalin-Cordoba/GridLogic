package com.example.gridlogicprototipo.ui.repository

import com.example.gridlogicprototipo.R
import com.example.gridlogicprototipo.ui.dao.ScoresDao
import com.example.gridlogicprototipo.ui.model.Dificultad
import com.example.gridlogicprototipo.ui.model.Ejercicio
import com.example.gridlogicprototipo.ui.model.Opcion
import com.example.gridlogicprototipo.ui.room_models.Scores

class GridLogicRepository(private val puntajesDao: ScoresDao) {

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

    suspend fun guardarPuntajeFinal(puntajeCalculado: Int) {
        val nuevoPuntaje = Scores(puntuacion = puntajeCalculado)
        puntajesDao.insertarPuntaje(nuevoPuntaje)
    }

    suspend fun obtenerHistorial(): List<Scores>{
        return puntajesDao.obtenerHistorialPuntajes()
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

        crearEjercicio(
            id = 4,
            dificultad = Dificultad.FACIL,
            imagenMatrizResId = R.drawable.matriz_facil_4,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_f4_a, "1"),
                Opcion(2, R.drawable.opcion_f4_b, "2"),
                Opcion(3, R.drawable.opcion_f4_c, "3"),
                Opcion(4, R.drawable.opcion_f4_d, "4"),
                Opcion(5, R.drawable.opcion_f4_e, "5"),
                Opcion(6, R.drawable.opcion_f4_f, "6")
            ),
            respuestaCorrectaId = 2
        ),

        crearEjercicio(
            id = 5,
            dificultad = Dificultad.FACIL,
            imagenMatrizResId = R.drawable.matriz_facil_5,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_f5_a, "1"),
                Opcion(2, R.drawable.opcion_f5_b, "2"),
                Opcion(3, R.drawable.opcion_f5_c, "3"),
                Opcion(4, R.drawable.opcion_f5_d, "4"),
                Opcion(5, R.drawable.opcion_f5_e, "5"),
                Opcion(6, R.drawable.opcion_f5_f, "6")
            ),
            respuestaCorrectaId = 6
        ),

        crearEjercicio(
            id = 6,
            dificultad = Dificultad.FACIL,
            imagenMatrizResId = R.drawable.matriz_facil_6,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_f6_a, "1"),
                Opcion(2, R.drawable.opcion_f6_b, "2"),
                Opcion(3, R.drawable.opcion_f6_c, "3"),
                Opcion(4, R.drawable.opcion_f6_d, "4"),
                Opcion(5, R.drawable.opcion_f6_e, "5"),
                Opcion(6, R.drawable.opcion_f6_f, "6")
            ),
            respuestaCorrectaId = 6
        ),

        crearEjercicio(
            id = 7,
            dificultad = Dificultad.FACIL,
            imagenMatrizResId = R.drawable.matriz_facil_7,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_f7_a, "1"),
                Opcion(2, R.drawable.opcion_f7_b, "2"),
                Opcion(3, R.drawable.opcion_f7_c, "3"),
                Opcion(4, R.drawable.opcion_f7_d, "4"),
                Opcion(5, R.drawable.opcion_f7_e, "5"),
                Opcion(6, R.drawable.opcion_f7_f, "6")
            ),
            respuestaCorrectaId = 3
        ),

        crearEjercicio(
            id = 8,
            dificultad = Dificultad.FACIL,
            imagenMatrizResId = R.drawable.matriz_facil_8,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_f8_a, "1"),
                Opcion(2, R.drawable.opcion_f8_b, "2"),
                Opcion(3, R.drawable.opcion_f8_c, "3"),
                Opcion(4, R.drawable.opcion_f8_d, "4"),
                Opcion(5, R.drawable.opcion_f8_e, "5"),
                Opcion(6, R.drawable.opcion_f8_f, "6")
            ),
            respuestaCorrectaId = 1
        ),

        crearEjercicio(
            id = 9,
            dificultad = Dificultad.FACIL,
            imagenMatrizResId = R.drawable.matriz_facil_9,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_f9_a, "1"),
                Opcion(2, R.drawable.opcion_f9_b, "2"),
                Opcion(3, R.drawable.opcion_f9_c, "3"),
                Opcion(4, R.drawable.opcion_f9_d, "4"),
                Opcion(5, R.drawable.opcion_f9_e, "5"),
                Opcion(6, R.drawable.opcion_f9_f, "6")
            ),
            respuestaCorrectaId = 4
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

        crearEjercicio(
            id = 14,
            dificultad = Dificultad.INTERMEDIO,
            imagenMatrizResId = R.drawable.matriz_intermedia_5,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_i5_a, "1"),
                Opcion(2, R.drawable.opcion_i5_b, "2"),
                Opcion(3, R.drawable.opcion_i5_c, "3"),
                Opcion(4, R.drawable.opcion_i5_d, "4"),
                Opcion(5, R.drawable.opcion_i5_e, "5"),
                Opcion(6, R.drawable.opcion_i5_f, "6")
            ),
            respuestaCorrectaId = 4
        ),

        crearEjercicio(
            id = 15,
            dificultad = Dificultad.INTERMEDIO,
            imagenMatrizResId = R.drawable.matriz_intermedia_6,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_i6_a, "1"),
                Opcion(2, R.drawable.opcion_i6_b, "2"),
                Opcion(3, R.drawable.opcion_i6_c, "3"),
                Opcion(4, R.drawable.opcion_i6_d, "4"),
                Opcion(5, R.drawable.opcion_i6_e, "5"),
                Opcion(6, R.drawable.opcion_i6_f, "6"),
                Opcion(7, R.drawable.opcion_i6_g, "7"),
                Opcion(8, R.drawable.opcion_i6_h, "8")
            ),
            respuestaCorrectaId = 5
        ),

        crearEjercicio(
            id = 16,
            dificultad = Dificultad.INTERMEDIO,
            imagenMatrizResId = R.drawable.matriz_intermedia_7,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_i7_a, "1"),
                Opcion(2, R.drawable.opcion_i7_b, "2"),
                Opcion(3, R.drawable.opcion_i7_c, "3"),
                Opcion(4, R.drawable.opcion_i7_d, "4"),
                Opcion(5, R.drawable.opcion_i7_e, "5"),
                Opcion(6, R.drawable.opcion_i7_f, "6"),
                Opcion(7, R.drawable.opcion_i7_g, "7"),
                Opcion(8, R.drawable.opcion_i7_h, "8")
            ),
            respuestaCorrectaId = 4
        ),

        crearEjercicio(
            id = 17,
            dificultad = Dificultad.INTERMEDIO,
            imagenMatrizResId = R.drawable.matriz_intermedia_8,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_i8_a, "1"),
                Opcion(2, R.drawable.opcion_i8_b, "2"),
                Opcion(3, R.drawable.opcion_i8_c, "3"),
                Opcion(4, R.drawable.opcion_i8_d, "4"),
                Opcion(5, R.drawable.opcion_i8_e, "5"),
                Opcion(6, R.drawable.opcion_i8_f, "6"),
                Opcion(7, R.drawable.opcion_i8_g, "7"),
                Opcion(8, R.drawable.opcion_i8_h, "8")
            ),
            respuestaCorrectaId = 3
        ),

        crearEjercicio(
            id = 18,
            dificultad = Dificultad.INTERMEDIO,
            imagenMatrizResId = R.drawable.matriz_intermedia_9,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_i9_a, "1"),
                Opcion(2, R.drawable.opcion_i9_b, "2"),
                Opcion(3, R.drawable.opcion_i9_c, "3"),
                Opcion(4, R.drawable.opcion_i9_d, "4"),
                Opcion(5, R.drawable.opcion_i9_e, "5"),
                Opcion(6, R.drawable.opcion_i9_f, "6"),
                Opcion(7, R.drawable.opcion_i9_g, "7"),
                Opcion(8, R.drawable.opcion_i9_h, "8")
            ),
            respuestaCorrectaId = 6
        ),

        crearEjercicio(
            id = 19,
            dificultad = Dificultad.INTERMEDIO,
            imagenMatrizResId = R.drawable.matriz_intermedia_10,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_i10_a, "1"),
                Opcion(2, R.drawable.opcion_i10_b, "2"),
                Opcion(3, R.drawable.opcion_i10_c, "3"),
                Opcion(4, R.drawable.opcion_i10_d, "4"),
                Opcion(5, R.drawable.opcion_i10_e, "5"),
                Opcion(6, R.drawable.opcion_i10_f, "6"),
                Opcion(7, R.drawable.opcion_i10_g, "7"),
                Opcion(8, R.drawable.opcion_i10_h, "8")
            ),
            respuestaCorrectaId = 8
        ),

        crearEjercicio(
            id = 20,
            dificultad = Dificultad.INTERMEDIO,
            imagenMatrizResId = R.drawable.matriz_intermedia_11,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_i11_a, "1"),
                Opcion(2, R.drawable.opcion_i11_b, "2"),
                Opcion(3, R.drawable.opcion_i11_c, "3"),
                Opcion(4, R.drawable.opcion_i11_d, "4"),
                Opcion(5, R.drawable.opcion_i11_e, "5"),
                Opcion(6, R.drawable.opcion_i11_f, "6"),
                Opcion(7, R.drawable.opcion_i11_g, "7"),
                Opcion(8, R.drawable.opcion_i11_h, "8")
            ),
            respuestaCorrectaId = 8
        ),

        crearEjercicio(
            id = 21,
            dificultad = Dificultad.INTERMEDIO,
            imagenMatrizResId = R.drawable.matriz_intermedia_12,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_i12_a, "1"),
                Opcion(2, R.drawable.opcion_i12_b, "2"),
                Opcion(3, R.drawable.opcion_i12_c, "3"),
                Opcion(4, R.drawable.opcion_i12_d, "4"),
                Opcion(5, R.drawable.opcion_i12_e, "5"),
                Opcion(6, R.drawable.opcion_i12_f, "6"),
                Opcion(7, R.drawable.opcion_i12_g, "7"),
                Opcion(8, R.drawable.opcion_i12_h, "8")
            ),
            respuestaCorrectaId = 6
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

        crearEjercicio(
            id = 25,
            dificultad = Dificultad.DIFICIL,
            imagenMatrizResId = R.drawable.matriz_dificil_4,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_d4_a, "1"),
                Opcion(2, R.drawable.opcion_d4_b, "2"),
                Opcion(3, R.drawable.opcion_d4_c, "3"),
                Opcion(4, R.drawable.opcion_d4_d, "4"),
                Opcion(5, R.drawable.opcion_d4_e, "5"),
                Opcion(6, R.drawable.opcion_d4_f, "6"),
                Opcion(7, R.drawable.opcion_d4_g, "7"),
                Opcion(8, R.drawable.opcion_d4_h, "8")
            ),
            respuestaCorrectaId = 5
        ),

        crearEjercicio(
            id = 26,
            dificultad = Dificultad.DIFICIL,
            imagenMatrizResId = R.drawable.matriz_dificil_5,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_d5_a, "1"),
                Opcion(2, R.drawable.opcion_d5_b, "2"),
                Opcion(3, R.drawable.opcion_d5_c, "3"),
                Opcion(4, R.drawable.opcion_d5_d, "4"),
                Opcion(5, R.drawable.opcion_d5_e, "5"),
                Opcion(6, R.drawable.opcion_d5_f, "6"),
                Opcion(7, R.drawable.opcion_d5_g, "7"),
                Opcion(8, R.drawable.opcion_d5_h, "8")
            ),
            respuestaCorrectaId = 7
        ),

        crearEjercicio(
            id = 27,
            dificultad = Dificultad.DIFICIL,
            imagenMatrizResId = R.drawable.matriz_dificil_6,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_d6_a, "1"),
                Opcion(2, R.drawable.opcion_d6_b, "2"),
                Opcion(3, R.drawable.opcion_d6_c, "3"),
                Opcion(4, R.drawable.opcion_d6_d, "4"),
                Opcion(5, R.drawable.opcion_d6_e, "5"),
                Opcion(6, R.drawable.opcion_d6_f, "6"),
                Opcion(7, R.drawable.opcion_d6_g, "7"),
                Opcion(8, R.drawable.opcion_d6_h, "8")
            ),
            respuestaCorrectaId = 5
        ),

        crearEjercicio(
            id = 28,
            dificultad = Dificultad.DIFICIL,
            imagenMatrizResId = R.drawable.matriz_dificil_7,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_d7_a, "1"),
                Opcion(2, R.drawable.opcion_d7_b, "2"),
                Opcion(3, R.drawable.opcion_d7_c, "3"),
                Opcion(4, R.drawable.opcion_d7_d, "4"),
                Opcion(5, R.drawable.opcion_d7_e, "5"),
                Opcion(6, R.drawable.opcion_d7_f, "6"),
                Opcion(7, R.drawable.opcion_d7_g, "7"),
                Opcion(8, R.drawable.opcion_d7_h, "8")
            ),
            respuestaCorrectaId = 7
        ),

        crearEjercicio(
            id = 29,
            dificultad = Dificultad.DIFICIL,
            imagenMatrizResId = R.drawable.matriz_dificil_8,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_d8_a, "1"),
                Opcion(2, R.drawable.opcion_d8_b, "2"),
                Opcion(3, R.drawable.opcion_d8_c, "3"),
                Opcion(4, R.drawable.opcion_d8_d, "4"),
                Opcion(5, R.drawable.opcion_d8_e, "5"),
                Opcion(6, R.drawable.opcion_d8_f, "6"),
                Opcion(7, R.drawable.opcion_d8_g, "7"),
                Opcion(8, R.drawable.opcion_d8_h, "8")
            ),
            respuestaCorrectaId = 8
        ),

        crearEjercicio(
            id = 30,
            dificultad = Dificultad.DIFICIL,
            imagenMatrizResId = R.drawable.matriz_dificil_9,
            opciones = listOf(
                Opcion(1, R.drawable.opcion_d9_a, "1"),
                Opcion(2, R.drawable.opcion_d9_b, "2"),
                Opcion(3, R.drawable.opcion_d9_c, "3"),
                Opcion(4, R.drawable.opcion_d9_d, "4"),
                Opcion(5, R.drawable.opcion_d9_e, "5"),
                Opcion(6, R.drawable.opcion_d9_f, "6"),
                Opcion(7, R.drawable.opcion_d9_g, "7"),
                Opcion(8, R.drawable.opcion_d9_h, "8")
            ),
            respuestaCorrectaId = 1
        ),
    )
}