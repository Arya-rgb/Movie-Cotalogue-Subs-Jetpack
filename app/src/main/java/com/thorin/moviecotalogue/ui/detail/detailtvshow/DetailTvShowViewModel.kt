package com.thorin.moviecotalogue.ui.detail.detailtvshow

import androidx.lifecycle.ViewModel
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.utils.DataHelper

class DetailTvShowViewModel : ViewModel() {

    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): TvShowEntity {
        lateinit var tvShow: TvShowEntity
        val tvShowEntities = DataHelper.generateDataTvShow()
        for (tvShowEntity in tvShowEntities) {
            if (tvShowId == tvShowEntity.tvShowId) {
                tvShow = tvShowEntity
            }
        }
        return tvShow
    }

}