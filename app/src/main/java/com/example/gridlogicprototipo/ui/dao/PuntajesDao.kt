package com.example.gridlogicprototipo.ui.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.gridlogicprototipo.ui.room_models.Puntajes

@Dao
interface PuntajesDao {

    @Query("SELECT * FROM puntuaciones")
    fun obtenerTodosLosPuntajes(): List<Puntajes>

    @Insert
    fun insertarPuntaje(score: Puntajes)

    @Update
    fun actualizarPuntaje(score: Puntajes)

    @Query("DELETE FROM puntuaciones WHERE id = :id")
    fun eliminarPuntajePorId(id: Int)
}