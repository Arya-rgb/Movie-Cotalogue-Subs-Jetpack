package com.thorin.moviecotalogue.ui.detail.detailmovie

import androidx.lifecycle.ViewModel
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.utils.DataHelper


class DetailMovieViewModel : ViewModel() {

    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): MovieEntity {
        lateinit var movie: MovieEntity
        val movieEntities = DataHelper.generateDataMovie()
        for (movieEntity in movieEntities) {
            if (movieId == movieEntity.movieId) {
                movie = movieEntity
            }
        }
        return movie
    }
}