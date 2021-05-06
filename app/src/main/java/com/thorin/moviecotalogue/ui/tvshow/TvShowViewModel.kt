package com.thorin.moviecotalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.data.source.FilmRepository

class TvShowViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getTvShow(): LiveData<List<TvShowEntity>> = filmRepository.getAllTvShow()

}