package com.thorin.moviecotalogue.data.source.remote

import com.thorin.moviecotalogue.data.source.remote.response.MovieResponse
import com.thorin.moviecotalogue.data.source.remote.response.TvShowResponse
import com.thorin.moviecotalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(): List<MovieResponse> = jsonHelper.loadMovies()

    fun getAllTvShow(): List<TvShowResponse> = jsonHelper.loadTvShow()

}