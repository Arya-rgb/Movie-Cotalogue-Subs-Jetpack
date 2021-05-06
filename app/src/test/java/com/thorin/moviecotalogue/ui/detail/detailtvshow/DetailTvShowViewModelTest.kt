package com.thorin.moviecotalogue.ui.detail.detailtvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.data.source.FilmRepository
import com.thorin.moviecotalogue.utils.DataHelper
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dataHelper = DataHelper.generateDataTvShow()[0]
    private val tvShowId = dataHelper.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(filmRepository)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dataHelper

        `when`(filmRepository.getTvShowDetail(tvShowId)).thenReturn(tvShow)
        val tvShowEntity = viewModel.getTvShow().value as TvShowEntity
        verify(filmRepository).getTvShowDetail(tvShowId)
        assertNotNull(tvShowEntity)
        assertEquals(dataHelper.tvShowId, tvShowEntity.tvShowId)
        assertEquals(dataHelper.tvShowName, tvShowEntity.tvShowName)
        assertEquals(dataHelper.tvShowRelease, tvShowEntity.tvShowRelease)
        assertEquals(dataHelper.tvShowRate, tvShowEntity.tvShowRate)
        assertEquals(dataHelper.tvShowDescription, tvShowEntity.tvShowDescription)
        assertEquals(dataHelper.tvShowGenre, tvShowEntity.tvShowGenre)
        assertEquals(dataHelper.tvShowLocation, tvShowEntity.tvShowLocation)
        assertEquals(dataHelper.tvShowTotalEpisode, tvShowEntity.tvShowTotalEpisode)
        assertEquals(dataHelper.imagePath, tvShowEntity.imagePath)

        viewModel.getTvShow().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dataHelper)
    }
}