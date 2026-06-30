package com.example.gridlogicprototipo.ui.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.gridlogicprototipo.ui.dao.AppDatabase
import com.example.gridlogicprototipo.ui.model.Dificultad
import com.example.gridlogicprototipo.ui.model.Ejercicio
import com.example.gridlogicprototipo.ui.repository.GridLogicRepository
import com.example.gridlogicprototipo.ui.room_models.Scores
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
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

    var puntuacionFinal by mutableStateOf(0)
    private set

    var rangoDiagnostico by mutableStateOf("")
    private set

    private var timerJob: Job? = null
    private var segundosTotalesRestantes = 12 * 60
    private var tiempoInicioEjercicioActual: Long = 0
    private var testFinalizadoPorSeguridad = false

    var historialPuntajes by mutableStateOf<List<Scores>>(emptyList())
        private set

    fun iniciarTest() {
        ejerciciosTest = repository.generarTestAleatorio()
        indiceActual = 0
        respuestasUsuario = emptyMap()
        puntuacionFinal = 0
        rangoDiagnostico = ""
        segundosTotalesRestantes = 12 * 60
        tiempoRestanteUI = "12:00"
        testFinalizadoPorSeguridad = false

        tiempoInicioEjercicioActual = System.currentTimeMillis()
        iniciarTemporizadorGlobal()
    }

    private fun iniciarTemporizadorGlobal() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch(Dispatchers.Main) {
            while (segundosTotalesRestantes > 0 && !testFinalizadoPorSeguridad) {
                delay(1000)
                segundosTotalesRestantes--

                val minutos = segundosTotalesRestantes / 60
                val segundos = segundosTotalesRestantes % 60
                tiempoRestanteUI = String.format("%02d:%02d", minutos, segundos)
            }

            // Finalizar prueba si se acaba el tiempo
            if (segundosTotalesRestantes <= 0 && !testFinalizadoPorSeguridad) {
                finalizarPruebaUrgente()
            }
        }
    }

    fun registrarRespuestaYavanzar(ejercicioId: Int, opcionId: Int, onTestTerminado: () -> Unit) {
        if (testFinalizadoPorSeguridad) return

        val tiempoInvertidoEnSegundos = (System.currentTimeMillis() - tiempoInicioEjercicioActual) / 1000
        val ejercicioActual = ejerciciosTest.getOrNull(indiceActual)

        // Registrar respuesta
        respuestasUsuario = respuestasUsuario.toMutableMap().apply {
            put(ejercicioId, opcionId)
        }

        // Evaluar y acumular puntaje si la respuesta es correcta
        if (ejercicioActual != null && opcionId == ejercicioActual.respuestaCorrectaId) {
            calcularYAcumularPuntos(ejercicioActual, tiempoInvertidoEnSegundos)
        }

        if (indiceActual < ejerciciosTest.size - 1) {
            indiceActual++
            tiempoInicioEjercicioActual = System.currentTimeMillis() // Reset para la siguiente pregunta
        } else {
            timerJob?.cancel()
            testFinalizadoPorSeguridad = true
            calcularRangoCualitativo()
            onTestTerminado()
        }
    }

    private fun calcularYAcumularPuntos(ejercicio: Ejercicio, tiempoInvertido: Long) {
        var puntosBase = 0
        var bonoVelocidadMaximo = 0
        var tiempoLimiteExcelenteSegundos = 0

        when (ejercicio.dificultad) {
            Dificultad.FACIL -> {
                puntosBase = 40
                bonoVelocidadMaximo = 20
                tiempoLimiteExcelenteSegundos = 20 // Menos de 20 segundos da bono completo
            }
            Dificultad.INTERMEDIO -> {
                puntosBase = 70
                bonoVelocidadMaximo = 30
                tiempoLimiteExcelenteSegundos = 45 // Menos de 45 segundos da bono completo
            }
            Dificultad.DIFICIL -> {
                puntosBase = 100
                bonoVelocidadMaximo = 40
                tiempoLimiteExcelenteSegundos = 90 // Menos de 90 segundos da bono completo
            }
        }

        // Aplicar disminución del bono por retraso en el tiempo empleado
        val factorPenalizacion = tiempoInvertido.toFloat() / (tiempoLimiteExcelenteSegundos * 2)
        val bonoCalculado = (bonoVelocidadMaximo * (1f - factorPenalizacion)).toInt().coerceIn(0, bonoVelocidadMaximo)

        puntuacionFinal += (puntosBase + bonoCalculado)
    }

    private fun finalizarPruebaUrgente() {
        timerJob?.cancel()
        testFinalizadoPorSeguridad = true
        calcularRangoCualitativo()
        // Puntuación congelada
    }

    private fun calcularRangoCualitativo() {
        rangoDiagnostico = when (puntuacionFinal) {
            in 0..399 -> "Razonamiento espacial inicial"
            in 400..649 -> "Capacidad lógica promedio"
            in 650..849 -> "Razonamiento abstracto superior"
            else -> "Inteligencia visual extraordinaria"
        }
    }

    fun obtenerEjercicioActual(): Ejercicio? {
        return ejerciciosTest.getOrNull(indiceActual)
    }

    fun registrarPuntajeEnBD() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Guarda el puntaje de la partida que acaba de terminar
                repository.guardarPuntajeFinal(puntuacionFinal)

                // Consulta a la BD y se actualiza la lista del historial
                historialPuntajes = repository.obtenerHistorial()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}