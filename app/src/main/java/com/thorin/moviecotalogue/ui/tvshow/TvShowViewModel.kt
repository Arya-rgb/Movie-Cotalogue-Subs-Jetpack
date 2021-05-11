package com.thorin.moviecotalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.data.source.FilmRepository
import com.thorin.moviecotalogue.vo.Resource

class TvShowViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> = filmRepository.getAllTvShow()

}