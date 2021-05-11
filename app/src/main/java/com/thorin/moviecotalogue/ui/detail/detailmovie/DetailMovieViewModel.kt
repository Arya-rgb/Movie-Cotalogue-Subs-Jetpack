package com.thorin.moviecotalogue.ui.detail.detailmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.source.FilmRepository
import com.thorin.moviecotalogue.vo.Resource


class DetailMovieViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    val movieId = MutableLiveData<String>()

    fun setSelectedMovie(movieId: String) {
        this.movieId.value = movieId
    }

    var movieData: LiveData<Resource<MovieEntity>> =
        Transformations.switchMap(movieId) { mMovieId ->
            filmRepository.getMoviesDetail(mMovieId)
        }

    fun getDetailMovieForTest(movieId: String): LiveData<MovieEntity> =
        filmRepository.getDetailMovieById(movieId)

    fun setFavorite() {
        val movieResource = movieData.value
        if (movieResource != null) {
            val detailMovie = movieResource.data

            if (detailMovie != null) {
                val newState = !detailMovie.favorite
                filmRepository.setMovieFavorite(detailMovie, newState)
            }
        }
    }

}