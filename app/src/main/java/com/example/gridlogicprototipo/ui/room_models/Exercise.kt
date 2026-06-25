package com.example.gridlogicprototipo.ui.room_models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gridlogicprototipo.ui.model.Dificultad

@Entity(tableName = "ejercicios")
data class Exercise (
    @PrimaryKey(autoGenerate = true) val id: Int = 1,
    val dificultad: Dificultad,
    val imagenMatrizResId: Int,
    val respuestaCorrectaId: Int
)