package com.thorin.moviecotalogue.ui.detail.detailmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.source.FilmRepository
import com.thorin.moviecotalogue.utils.DataHelper


class DetailMovieViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }
    fun getMovie(): LiveData<MovieEntity> = filmRepository.getMoviesDetail(movieId)
}