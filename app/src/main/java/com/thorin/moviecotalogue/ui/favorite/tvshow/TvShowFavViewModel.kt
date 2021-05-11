package com.thorin.moviecotalogue.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.data.source.FilmRepository

class TvShowFavViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getTvShow(): LiveData<PagedList<TvShowEntity>> {
        return filmRepository.getFavoriteTvShow()
    }
}