package com.example.gridlogicprototipo.ui.room_models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "puntuaciones")
data class Puntajes (
    @PrimaryKey(autoGenerate = true) val id: Int = 1,
    val puntuacion: Int
)