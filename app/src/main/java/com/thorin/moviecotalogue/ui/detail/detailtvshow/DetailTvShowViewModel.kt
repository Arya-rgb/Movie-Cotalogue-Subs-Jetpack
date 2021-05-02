package com.thorin.moviecotalogue.ui.detail.detailtvshow

import androidx.lifecycle.ViewModel
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.data.source.FilmRepository
import com.thorin.moviecotalogue.utils.DataHelper

class DetailTvShowViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): TvShowEntity = filmRepository.getTvShowDetail(tvShowId)

}