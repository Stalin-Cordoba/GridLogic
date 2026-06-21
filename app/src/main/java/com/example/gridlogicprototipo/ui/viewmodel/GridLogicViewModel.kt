package com.example.gridlogicprototipo.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.gridlogicprototipo.ui.model.Ejercicio
import com.example.gridlogicprototipo.ui.repository.GridLogicRepository

class GridLogicViewModel: ViewModel() {
    private val repository = GridLogicRepository()

    var ejerciciosTest by mutableStateOf<List<Ejercicio>>(emptyList())
        private set

    var indiceActual by mutableStateOf(0)
        private set

    var tiempoRestanteUI by mutableStateOf("12:00")
        private set

    var respuestasUsuario by mutableStateOf<Map<Int, Int>>(emptyMap())
        private set

    fun iniciarTest() {
        ejerciciosTest = repository.generarTestAleatorio()
        indiceActual = 0
        respuestasUsuario = emptyMap()
        tiempoRestanteUI = "12:00"
    }

    fun registrarRespuestaYavanzar(ejercicioId: Int, opcionId: Int, onTestTerminado: () -> Unit) {
        respuestasUsuario = respuestasUsuario.toMutableMap().apply {
            put(ejercicioId, opcionId)
        }

        if (indiceActual < ejerciciosTest.size - 1) {
            indiceActual++
        } else {
            onTestTerminado()
        }
    }

    fun obtenerEjercicioActual(): Ejercicio? {
        return ejerciciosTest.getOrNull(indiceActual)
    }
}