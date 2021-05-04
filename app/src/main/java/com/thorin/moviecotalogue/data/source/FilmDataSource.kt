package com.thorin.moviecotalogue.data.source

import androidx.lifecycle.LiveData
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.TvShowEntity

interface FilmDataSource {

    fun getAllMovies(): LiveData<List<MovieEntity>>

    fun getAllTvShow(): LiveData<List<TvShowEntity>>

    fun getMoviesDetail(movieId: String): LiveData<MovieEntity>

    fun getTvShowDetail(tvShowId: String): LiveData<TvShowEntity>

}