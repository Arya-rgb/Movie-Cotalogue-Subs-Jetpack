package com.thorin.moviecotalogue.ui.detail.detailtvshow

import com.thorin.moviecotalogue.utils.DataHelper
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*


class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dataHelper = DataHelper.generateDataTvShow()[0]
    private val tvShowId = dataHelper.tvShowId

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel()
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedTvShow(dataHelper.tvShowId)
        val tvShowEntity = viewModel.getTvShow()
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