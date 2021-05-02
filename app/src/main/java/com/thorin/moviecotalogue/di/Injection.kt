package com.thorin.moviecotalogue.di

import android.content.Context
import com.thorin.moviecotalogue.data.source.FilmRepository
import com.thorin.moviecotalogue.data.source.remote.RemoteDataSource
import com.thorin.moviecotalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): FilmRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return FilmRepository.getInstance(remoteDataSource)
    }
}