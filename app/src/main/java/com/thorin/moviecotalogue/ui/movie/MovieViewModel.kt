package com.thorin.moviecotalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.source.FilmRepository

class MovieViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getMovie(): LiveData<List<MovieEntity>> = filmRepository.getAllMovies()

}