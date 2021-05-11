package com.thorin.moviecotalogue.di

import android.content.Context
import com.thorin.moviecotalogue.data.source.FilmRepository
import com.thorin.moviecotalogue.data.source.local.LocalDataSource
import com.thorin.moviecotalogue.data.source.local.room.FilmDatabase
import com.thorin.moviecotalogue.data.source.remote.RemoteDataSource
import com.thorin.moviecotalogue.utils.AppExecutors
import com.thorin.moviecotalogue.utils.JsonHelper

object Injection {

        fun provideRepository(context: Context): FilmRepository {

            val database = FilmDatabase.getDatabase(context)

            val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
            val localDataSource = LocalDataSource.getInstance(database.filmDao())
            val appExecutors = AppExecutors()
            return FilmRepository.getInstance(remoteDataSource,localDataSource,appExecutors )
        }
}