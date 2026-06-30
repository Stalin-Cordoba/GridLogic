package com.example.gridlogicprototipo.ui.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.gridlogicprototipo.ui.room_models.Scores

@Dao
interface ScoresDao {

    @Query("SELECT * FROM puntuaciones")
    fun obtenerTodosLosPuntajes(): List<Scores>

    @Query("SELECT * FROM puntuaciones ORDER BY id DESC")
    suspend fun obtenerHistorialPuntajes(): List<Scores>

    @Insert
    suspend fun insertarPuntaje(score: Scores)

    @Update
    fun actualizarPuntaje(score: Scores)

    @Query("DELETE FROM puntuaciones WHERE id = :id")
    fun eliminarPuntajePorId(id: Int)
}