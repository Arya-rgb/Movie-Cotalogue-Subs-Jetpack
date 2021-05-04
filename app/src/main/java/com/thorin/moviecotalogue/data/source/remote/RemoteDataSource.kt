package com.thorin.moviecotalogue.data.source.remote

import android.os.Looper
import com.thorin.moviecotalogue.data.source.remote.response.MovieResponse
import com.thorin.moviecotalogue.data.source.remote.response.TvShowResponse
import com.thorin.moviecotalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = android.os.Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }



    fun getAllMovies(callback: LoadMoviesCallback) {
        handler.postDelayed({
            callback.onAllMovieReceived(jsonHelper.loadMovies())
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getAllTvShow(callback: LoadTvShowCallback) {
        handler.postDelayed({
            callback.onAllTvShowReceived(jsonHelper.loadTvShow())
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback {
        fun onAllMovieReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadTvShowCallback {
        fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>)
    }


}