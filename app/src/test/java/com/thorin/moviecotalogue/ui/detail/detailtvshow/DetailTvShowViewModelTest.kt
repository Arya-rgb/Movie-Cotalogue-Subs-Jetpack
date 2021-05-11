package com.thorin.moviecotalogue.ui.detail.detailtvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.data.source.FilmRepository
import com.thorin.moviecotalogue.utils.DataHelper
import com.thorin.moviecotalogue.vo.Resource
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
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
    private lateinit var tvShowObserver: Observer<Resource<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(filmRepository)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {

        val tvShowDummy = MutableLiveData<TvShowEntity>()
        tvShowDummy.value = dataHelper

        `when`(filmRepository.getDetailTvShowById(tvShowId)).thenReturn(tvShowDummy)
        val tvShowData = viewModel.getTvShowForTest(tvShowId).value as TvShowEntity
        assertEquals(dataHelper.tvShowId, tvShowData.tvShowId)
        assertEquals(dataHelper.tvShowName, tvShowData.tvShowName)
        assertEquals(dataHelper.tvShowRelease, tvShowData.tvShowRelease)
        assertEquals(dataHelper.tvShowRate, tvShowData.tvShowRate)
        assertEquals(dataHelper.tvShowDescription, tvShowData.tvShowDescription)
        assertEquals(dataHelper.tvShowGenre, tvShowData.tvShowGenre)
        assertEquals(dataHelper.tvShowLocation, tvShowData.tvShowLocation)
        assertEquals(dataHelper.tvShowTotalEpisode, tvShowData.tvShowTotalEpisode)
        assertEquals(dataHelper.imagePath, tvShowData.imagePath)

        viewModel.tvData.observeForever(tvShowObserver)
//        com.nhaarman.mockitokotlin2.verify(tvShowObserver).onChanged(tvObserver)

    }
}