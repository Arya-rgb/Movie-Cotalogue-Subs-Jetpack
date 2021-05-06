package com.thorin.moviecotalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.thorin.moviecotalogue.data.source.remote.RemoteDataSource
import com.thorin.moviecotalogue.utils.DataHelper
import com.thorin.moviecotalogue.utils.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val filmRepository = FakeFilmRepository(remote)


    private val movieResponse = DataHelper.generateRemoteDataMovie()
    private val movieId = movieResponse[0].movieId
    private val tvShowResponse = DataHelper.generateRemoteDataTvShow()
    private val tvShowId = tvShowResponse[0].tvShowId

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMovieReceived(movieResponse)
        }.`when`(remote).getAllMovies(com.nhaarman.mockitokotlin2.any())
        val movieEntities = LiveDataTestUtil.getValue(filmRepository.getAllMovies())
        verify(remote).getAllMovies(com.nhaarman.mockitokotlin2.any())
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())

    }

    @Test
    fun getAllTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvShowResponse)
        }.`when`(remote).getAllTvShow(com.nhaarman.mockitokotlin2.any())
        val tvShowEntities = LiveDataTestUtil.getValue(filmRepository.getAllTvShow())
        verify(remote).getAllTvShow(com.nhaarman.mockitokotlin2.any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getMoviesDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMovieReceived(movieResponse)
            null
        }.`when`(remote).getAllMovies(com.nhaarman.mockitokotlin2.any())
        val movieEntities = LiveDataTestUtil.getValue(filmRepository.getMoviesDetail(movieId))
        verify(remote).getAllMovies(com.nhaarman.mockitokotlin2.any())
        assertNotNull(movieEntities)
        assertNotNull(movieEntities.movieName)
        assertEquals(movieResponse[0].movieName, movieEntities.movieName)

    }

    @Test
    fun getTvShowDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvShowResponse)
        }.`when`(remote).getAllTvShow(com.nhaarman.mockitokotlin2.any())
        val tvShowEntities = LiveDataTestUtil.getValue(filmRepository.getTvShowDetail(tvShowId))
        verify(remote).getAllTvShow(com.nhaarman.mockitokotlin2.any())
        assertNotNull(tvShowEntities)
        assertNotNull(tvShowEntities.tvShowName)
        assertEquals(tvShowResponse[0].tvShowName, tvShowEntities.tvShowName)
    }
}