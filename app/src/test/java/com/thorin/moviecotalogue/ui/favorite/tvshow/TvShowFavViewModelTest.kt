package com.thorin.moviecotalogue.ui.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.TvShowEntity
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


@RunWith(MockitoJUnitRunner::class)
class TvShowFavViewModelTest {

    private lateinit var viewModel: TvShowFavViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var tvShowPagedList: PagedList<TvShowEntity>

    @Before
    fun setup() {
        viewModel = TvShowFavViewModel(filmRepository)
    }

    @Test
    fun `get List For tvShow Favorite`() {
        val dataTvShow = tvShowPagedList
        Mockito.`when`(dataTvShow.size).thenReturn(10)
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = dataTvShow

        Mockito.`when`(filmRepository.getFavoriteTvShow()).thenReturn(tvShow)
        val tvShowEntity = viewModel.getTvShow().value
        Mockito.verify(filmRepository).getFavoriteTvShow()
        Assert.assertNotNull(tvShowEntity)
        Assert.assertEquals(10, tvShowEntity?.size)

        viewModel.getTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dataTvShow)
    }





}