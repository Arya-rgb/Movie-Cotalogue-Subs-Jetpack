package com.thorin.moviecotalogue.ui.detail.detailmovie

import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.source.FilmRepository
import com.thorin.moviecotalogue.utils.DataHelper
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dataHelper = DataHelper.generateDataMovie()[0]
    private val movieId = dataHelper.movieId

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(filmRepository)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        `when`(filmRepository.getMoviesDetail(movieId)).thenReturn(dataHelper)
        val movieEntity = viewModel.getMovie()
        verify(filmRepository).getMoviesDetail(movieId)
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