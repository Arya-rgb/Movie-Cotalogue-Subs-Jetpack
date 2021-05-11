package com.thorin.moviecotalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(filmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(filmDao).apply {
                INSTANCE = this
            }
    }

    fun setFavoriteMovie(movie: MovieEntity) {
        mFilmDao.insert(movie)
    }


    fun setMovieFavorite(movie: MovieEntity, NewState: Boolean) {
        movie.favorite = NewState
        mFilmDao.updateMovie(movie)
    }

    fun getAllMovie(): DataSource.Factory<Int, MovieEntity> = mFilmDao.getAllMovie()

    fun getAllTvShow(): DataSource.Factory<Int, TvShowEntity> = mFilmDao.getAllTvShow()

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = mFilmDao.getFavoriteMovie()

    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowEntity> = mFilmDao.getFavoriteTvShow()

    fun getDetailMovieById(movieId: String): LiveData<MovieEntity> =
        mFilmDao.getDetailWithMovieId(movieId)

    fun getDetailTvShowById(tvShowId: String): LiveData<TvShowEntity> =
        mFilmDao.getDetailWithTvId(tvShowId)

    fun insertMoviesList(movies: List<MovieEntity>) = mFilmDao.insertMovies(movies)

    fun insertTvShowList(tvShow: List<TvShowEntity>) = mFilmDao.insertTvShow(tvShow)

    fun setTvShowFavorite(tvShow: TvShowEntity, NewState: Boolean) {
        tvShow.favorite = NewState
        mFilmDao.updateTvShow(tvShow)
    }

}