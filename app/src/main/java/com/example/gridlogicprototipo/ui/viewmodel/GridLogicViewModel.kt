package com.example.gridlogicprototipo.ui.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gridlogicprototipo.ui.dao.AppDatabase
import com.example.gridlogicprototipo.ui.dao.PuntajesDao
import com.example.gridlogicprototipo.ui.model.Ejercicio
import com.example.gridlogicprototipo.ui.repository.GridLogicRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GridLogicViewModel(application: Application) : AndroidViewModel(application) {

    private val baseDatos = AppDatabase.getDatabase(application)
    private val repository = GridLogicRepository(puntajesDao = baseDatos.PuntajesDao())

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

    // Agrega esta función que será llamada desde la ResultsScreen
    fun registrarPuntajeEnBD() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.guardarPuntajeRandom()
            } catch (e: Exception) {
                // Manejar error si la inserción falla (opcional)
                e.printStackTrace()
            }
        }
    }
}