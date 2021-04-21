package com.thorin.moviecotalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.utils.DataHelper

class MovieViewModel : ViewModel() {

    fun getMovie(): List<MovieEntity> = DataHelper.generateDataMovie()

}