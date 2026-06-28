package com.example.gridlogicprototipo.ui.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gridlogicprototipo.ui.room_models.Scores

@Database(entities = [Scores::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    // Definimos el acceso al DAO
    abstract fun PuntajesDao(): ScoresDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Patrón Singleton para evitar abrir múltiples instancias de la base de datos
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "gridlogic_database" // El nombre físico del archivo de la BD en el teléfono
                )
                    // Opcional: permite recrear la BD si cambias la versión sin migración
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}