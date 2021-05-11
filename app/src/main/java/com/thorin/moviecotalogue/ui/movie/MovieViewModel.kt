package com.thorin.moviecotalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.source.FilmRepository
import com.thorin.moviecotalogue.vo.Resource

class MovieViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>> = filmRepository.getAllMovies()

}