package com.thorin.moviecotalogue.ui.favorite.movie


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.source.FilmRepository
import com.thorin.moviecotalogue.utils.DataHelper
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class MovieFragmentFavViewModelTest {

    private lateinit var viewModel: MovieFragmentFavViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = MovieFragmentFavViewModel(filmRepository)
    }



    @Test
    fun `get list for Movie favorite`() {

        val dataMovie = moviePagedList
        Mockito.`when`(dataMovie.size).thenReturn(10)
        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = dataMovie

        Mockito.`when`(filmRepository.getFavoriteMovie()).thenReturn(movie)
        val movieEntity = viewModel.getMovies().value
        Mockito.verify(filmRepository).getFavoriteMovie()
        Assert.assertNotNull(movieEntity)
        Assert.assertEquals(10, movieEntity?.size)

        viewModel.getMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dataMovie)
    }

}