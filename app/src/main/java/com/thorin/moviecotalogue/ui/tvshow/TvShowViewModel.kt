package com.thorin.moviecotalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.utils.DataHelper

class TvShowViewModel : ViewModel() {

    fun getTvShow(): List<TvShowEntity> = DataHelper.generateDataTvShow()

}