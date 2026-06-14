package com.example.gridlogicprototipo.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.gridlogicprototipo.ui.model.Ejercicio
import com.example.gridlogicprototipo.ui.repository.GridLogicRepository

class GridLogicViewModel: ViewModel() {
    private val repository = GridLogicRepository()

    var respuestasUsuario by mutableStateOf<Map<Int, Int>>(emptyMap())
        private set

    fun obtenerEjercicio(ejercicioId: Int): Ejercicio {
        return repository.obtenerEjercicio(ejercicioId)
    }

    fun seleccionarOpcion(ejercicioId: Int, opcionId: Int) {
        respuestasUsuario = respuestasUsuario.toMutableMap().apply {
            put(ejercicioId, opcionId)
        }
    }
}