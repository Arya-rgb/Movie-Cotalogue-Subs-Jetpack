package com.thorin.moviecotalogue.ui.detail.detailmovie

import com.thorin.moviecotalogue.utils.DataHelper
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dataHelper = DataHelper.generateDataMovie()[0]
    private val movieId = dataHelper.movieId

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dataHelper.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dataHelper.movieId, movieEntity.movieId)
        assertEquals(dataHelper.movieName, movieEntity.movieName)
        assertEquals(dataHelper.movieRelease, movieEntity.movieRelease)
        assertEquals(dataHelper.movieRate, movieEntity.movieRate)
        assertEquals(dataHelper.movieDescription, movieEntity.movieDescription)
        assertEquals(dataHelper.movieGenre, movieEntity.movieGenre)
        assertEquals(dataHelper.movieLocation, movieEntity.movieLocation)
        assertEquals(dataHelper.imagePath, movieEntity.imagePath)
    }
}