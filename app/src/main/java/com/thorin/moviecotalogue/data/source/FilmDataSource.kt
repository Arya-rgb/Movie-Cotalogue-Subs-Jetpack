package com.thorin.moviecotalogue.data.source

import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.TvShowEntity

interface FilmDataSource {

    fun getAllMovies(): List<MovieEntity>

    fun getAllTvShow(): List<TvShowEntity>

    fun getMoviesDetail(movieId: String): MovieEntity

    fun getTvShowDetail(tvShowId: String): TvShowEntity

}