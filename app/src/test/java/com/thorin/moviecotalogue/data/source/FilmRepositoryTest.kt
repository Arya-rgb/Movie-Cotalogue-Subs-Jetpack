package com.thorin.moviecotalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.data.source.local.LocalDataSource
import com.thorin.moviecotalogue.data.source.remote.RemoteDataSource
import com.thorin.moviecotalogue.utils.AppExecutors
import com.thorin.moviecotalogue.utils.DataHelper
import com.thorin.moviecotalogue.utils.LiveDataTestUtil
import com.thorin.moviecotalogue.utils.PagedListUtil
import com.thorin.moviecotalogue.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remoteDataSource = mock(RemoteDataSource::class.java)
    private val localDataSource = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val filmRepository = FakeFilmRepository(remoteDataSource, localDataSource, appExecutors)
    private val movieResponse = DataHelper.generateRemoteDataMovie()
    private val tvShowResponse = DataHelper.generateRemoteDataTvShow()
    private val movieDataList = DataHelper.generateDataMovie()
    private val tvShowDataList = DataHelper.generateDataTvShow()
    private val movieData = DataHelper.generateDataMovie()[0]
    private val tvShowData = DataHelper.generateDataTvShow()[0]

    @Test
    fun getAllMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(localDataSource.getAllMovie()).thenReturn(dataSourceFactory)
        filmRepository.getAllMovies()
        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataHelper.generateDataMovie()))
        com.nhaarman.mockitokotlin2.verify(localDataSource).getAllMovie()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(localDataSource.getAllTvShow()).thenReturn(dataSourceFactory)
        filmRepository.getAllTvShow()
        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataHelper.generateDataTvShow()))
        com.nhaarman.mockitokotlin2.verify(localDataSource).getAllTvShow()
        assertNotNull(movieEntities.data)
        assertEquals(tvShowResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMoviesDetail() {
        val dataHelper = MutableLiveData<MovieEntity>()
        dataHelper.value = movieData
        `when`(localDataSource.getDetailMovieById(movieData.movieId)).thenReturn(dataHelper)
        val data = LiveDataTestUtil.getValue(filmRepository.getMoviesDetail(movieData.movieId))
        verify(localDataSource).getDetailMovieById(movieData.movieId)
        assertNotNull(data)
        assertEquals(movieData.movieId, data.data?.movieId)

    }

    @Test
    fun getTvShowDetail() {
        val dataHelper = MutableLiveData<TvShowEntity>()
        dataHelper.value = tvShowData
        `when`(localDataSource.getDetailTvShowById(tvShowData.tvShowId)).thenReturn(dataHelper)
        val data = LiveDataTestUtil.getValue(filmRepository.getTvShowDetail(tvShowData.tvShowId))
        verify(localDataSource).getDetailTvShowById(tvShowData.tvShowId)
        assertNotNull(data)
        assertEquals(tvShowData.tvShowId, data.data?.tvShowId)
    }

    @Test
    fun getAllMovieFav() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(localDataSource.getFavoriteMovie()).thenReturn(dataSourceFactory)
        filmRepository.getFavoriteMovie()
        val movieEntity =
            Resource.success(PagedListUtil.mockPagedList(DataHelper.generateDataMovie()))
        verify(localDataSource).getFavoriteMovie()
        assertNotNull(movieEntity.data)
        assertEquals(movieDataList.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getAllTvShowFav() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(localDataSource.getFavoriteTvShow()).thenReturn(dataSourceFactory)
        filmRepository.getFavoriteTvShow()
        val tvShowEntity =
            Resource.success(PagedListUtil.mockPagedList(DataHelper.generateDataTvShow()))
        verify(localDataSource).getFavoriteTvShow()
        assertNotNull(tvShowEntity.data)
        assertEquals(tvShowDataList.size.toLong(), tvShowEntity.data?.size?.toLong())
    }

}