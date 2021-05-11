package com.thorin.moviecotalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.vo.Resource

interface FilmDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllTvShow(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getMoviesDetail(movieId: String): LiveData<Resource<MovieEntity>>

    fun getTvShowDetail(tvShowId: String): LiveData<Resource<TvShowEntity>>

    fun setFavoriteMovie(movie: MovieEntity)

    fun getAllMovie(): LiveData<PagedList<MovieEntity>>

    fun getAllTvShows(): LiveData<PagedList<TvShowEntity>>

    fun setTvShowFavorite(tvShow: TvShowEntity, NewState: Boolean)

    fun setMovieFavorite(movie: MovieEntity, NewState: Boolean)

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>>

    fun getDetailTvShowById(tvShowId: String): LiveData<TvShowEntity>

    fun getDetailMovieById(movieId: String): LiveData<MovieEntity>

}