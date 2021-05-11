package com.thorin.moviecotalogue.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.source.FilmRepository

class MovieFragmentFavViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getMovies(): LiveData<PagedList<MovieEntity>> {
        return filmRepository.getFavoriteMovie()
    }

}