package com.thorin.moviecotalogue.ui.detail.detailmovie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.source.FilmRepository
import com.thorin.moviecotalogue.utils.DataHelper
import com.thorin.moviecotalogue.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dataHelper = DataHelper.generateDataMovie()[0]
    private val movieId = dataHelper.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>



    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(filmRepository)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {

        val movieData = MutableLiveData<MovieEntity>()
        movieData.value = dataHelper

        `when`(filmRepository.getDetailMovieById(movieId)).thenReturn(movieData)
        val movieEntity = viewModel.getDetailMovieForTest(movieId).value as MovieEntity
        assertNotNull(movieEntity)
        assertEquals(dataHelper.movieId, movieEntity.movieId)
        assertEquals(dataHelper.movieName, movieEntity.movieName)
        assertEquals(dataHelper.movieRelease, movieEntity.movieRelease)
        assertEquals(dataHelper.movieRate, movieEntity.movieRate)
        assertEquals(dataHelper.movieDescription, movieEntity.movieDescription)
        assertEquals(dataHelper.movieGenre, movieEntity.movieGenre)
        assertEquals(dataHelper.movieLocation, movieEntity.movieLocation)
        assertEquals(dataHelper.imagePath, movieEntity.imagePath)
        viewModel.movieData.observeForever(movieObserver)


    }
}