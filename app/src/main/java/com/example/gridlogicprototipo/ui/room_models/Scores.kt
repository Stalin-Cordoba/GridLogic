package com.example.gridlogicprototipo.ui.room_models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "puntuaciones")
data class Scores (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val puntuacion: Int
)