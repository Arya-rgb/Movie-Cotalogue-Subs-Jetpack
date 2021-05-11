package com.thorin.moviecotalogue.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.TvShowEntity

@Database(entities = [MovieEntity::class, TvShowEntity::class], version = 1, exportSchema = false)
abstract class FilmDatabase : RoomDatabase() {

    abstract fun filmDao(): FilmDao

    companion object {
        @Volatile
        private var INSTANCE: FilmDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): FilmDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    FilmDatabase::class.java,
                    "film_database.db"
                ).allowMainThreadQueries().build().apply { INSTANCE = this }
            }
    }
}