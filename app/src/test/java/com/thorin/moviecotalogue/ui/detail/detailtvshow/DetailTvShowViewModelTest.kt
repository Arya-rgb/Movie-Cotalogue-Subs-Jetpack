package com.thorin.moviecotalogue.ui.detail.detailtvshow

import com.thorin.moviecotalogue.data.source.FilmRepository
import com.thorin.moviecotalogue.utils.DataHelper
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
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

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(filmRepository)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        `when`(filmRepository.getTvShowDetail(tvShowId)).thenReturn(dataHelper)
        val tvShowEntity = viewModel.getTvShow()
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
    }
}