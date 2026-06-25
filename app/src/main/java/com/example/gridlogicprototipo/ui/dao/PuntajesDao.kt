package com.example.gridlogicprototipo.ui.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.gridlogicprototipo.ui.room_models.Puntajes

@Dao
interface PuntajesDao {

    @Query("SELECT * FROM puntuaciones")
    fun obtenerTodosLosEjercicios(): List<Puntajes>

    @Insert
    fun insertarEjercicio(ejercicio: Puntajes)

    @Update
    fun actualizarEjercicio(ejercicio: Puntajes)

    @Query("DELETE FROM puntuaciones WHERE id = :id")
    fun eliminarEjercicioPorId(id: Int)
}