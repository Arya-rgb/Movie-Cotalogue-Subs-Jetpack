package com.thorin.moviecotalogue.data.source

import android.provider.ContactsContract
import com.thorin.moviecotalogue.data.source.remote.RemoteDataSource
import com.thorin.moviecotalogue.data.source.remote.response.MovieResponse
import com.thorin.moviecotalogue.data.source.remote.response.TvShowResponse
import com.thorin.moviecotalogue.utils.DataHelper
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class FilmRepositoryTest {

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val filmRepository = FakeFilmRepository(remote)

    private val movieResponse = DataHelper.generateRemoteDataMovie()
    private val movieId = movieResponse[0].movieId
    private val tvShowResponse = DataHelper.generateRemoteDataTvShow()
    private val tvShowId = tvShowResponse[0].tvShowId

    @Test
    fun getAllMovies() {
        `when`(remote.getAllMovies()).thenReturn(movieResponse)
        val movieEntities = filmRepository.getAllMovies()
        verify(remote).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvShow() {
        `when`(remote.getAllTvShow()).thenReturn(tvShowResponse)
        val tvShowEntities = filmRepository.getAllTvShow()
        verify(remote).getAllTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getMoviesDetail() {
        `when`(remote.getAllMovies()).thenReturn(movieResponse)
        val resultMovie = filmRepository.getMoviesDetail(movieId)
        verify(remote).getAllMovies()
        assertNotNull(resultMovie)
        assertEquals(movieResponse[0].movieName, resultMovie.movieName)
    }

    @Test
    fun getTvShowDetail() {
        `when`(remote.getAllTvShow()).thenReturn(tvShowResponse)
        val resultTvShow = filmRepository.getTvShowDetail(tvShowId)
        verify(remote).getAllTvShow()
        assertNotNull(resultTvShow)
        assertEquals(tvShowResponse[0].tvShowName, resultTvShow.tvShowName)
    }
}