package com.thorin.moviecotalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.TvShowEntity

@Dao
interface FilmDao {

    @Insert(onConflict = REPLACE)
    fun insert(movie: MovieEntity): Long

    @Query("DELETE FROM movie_entities WHERE movieId = :id")
    fun deleteMovieById(id: String)

    @Query("SELECT * FROM movie_entities")
    fun getAllMovie(): androidx.paging.DataSource.Factory<Int, MovieEntity>

    @Transaction
    @Query("SELECT * FROM movie_entities WHERE movieId = :movieId")
    fun getDetailWithMovieId(movieId: String): LiveData<MovieEntity>

    @Insert(onConflict = REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateMovies(movie: MovieEntity)

    @Query("SELECT * FROM movie_entities WHERE favorite = 1")
    fun getFavoriteMovie(): androidx.paging.DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvShow_entities WHERE favorite = 1")
    fun getFavoriteTvShow(): androidx.paging.DataSource.Factory<Int, TvShowEntity>

    @Update
    fun updateTvShow(tvShow: TvShowEntity)

    @Insert(onConflict = REPLACE)
    fun insertTvShow(tvShow: List<TvShowEntity>)

    @Insert(onConflict = REPLACE)
    fun insertTvShow(tvShow: TvShowEntity): Long

    @Query("SELECT * FROM tvShow_entities WHERE tvShowId = :id")
    fun getTvShowById(id: String?): TvShowEntity?

    @Query("DELETE FROM tvShow_entities WHERE tvShowId = :id")
    fun deleteTvShowById(id: String)

    @Query("SELECT * FROM tvShow_entities")
    fun getAllTvShow(): androidx.paging.DataSource.Factory<Int, TvShowEntity>

    @Transaction
    @Query("SELECT * FROM tvShow_entities WHERE tvShowId = :tvShowId")
    fun getDetailWithTvId(tvShowId: String): LiveData<TvShowEntity>

}