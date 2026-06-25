package com.example.gridlogicprototipo.ui.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.gridlogicprototipo.ui.room_models.Exercise

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM ejercicios")
    fun obtenerTodosLosEjercicios(): List<Exercise>

    @Query("SELECT * FROM ejercicios WHERE id = :id")
    fun obtenerEjercicioPorId(id: Int): Exercise?

    @Query("SELECT * FROM ejercicios WHERE dificultad = :dificultad")
    fun obtenerEjerciciosPorDificultad(dificultad: String): List<Exercise>

    @Insert
    fun insertarEjercicio(ejercicio: Exercise)

    @Update
    fun actualizarEjercicio(ejercicio: Exercise)

    @Query("DELETE FROM ejercicios WHERE id = :id")
    fun eliminarEjercicioPorId(id: Int)
}