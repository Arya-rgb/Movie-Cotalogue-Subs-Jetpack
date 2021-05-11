package com.thorin.moviecotalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.thorin.moviecotalogue.data.MovieEntity
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
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowEntity>>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(filmRepository)
    }

    @Test
    fun `getCourses should be success`() {
        val tvShow = PagedTestDataSources.snapshot(DataHelper.generateDataTvShow())
        val expected = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        expected.value = Resource.success(tvShow)

        `when`(filmRepository.getAllTvShow()).thenReturn(expected)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getTvShow().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.data, actualValue?.data)
        assertEquals(expectedValue?.data?.size, actualValue?.data?.size)
    }

    @Test
    fun `getCourses should be success but data is empty`() {
        val tvShow = PagedTestDataSources.snapshot()
        val expected = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        expected.value = Resource.success(tvShow)

        `when`(filmRepository.getAllTvShow()).thenReturn(expected)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val actualValueDataSize = viewModel.getTvShow().value?.data?.size
        Assert.assertTrue(
            "size of data should be 0, actual is $actualValueDataSize",
            actualValueDataSize == 0
        )
    }

    @Test
    fun `getCourses should be error`() {
        val expectedMessage = "Something happen dude!"
        val expected = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        expected.value = Resource.error(expectedMessage, null)

        `when`(filmRepository.getAllTvShow()).thenReturn(expected)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val actualMessage = viewModel.getTvShow().value?.message
        assertEquals(expectedMessage, actualMessage)
    }

    class PagedTestDataSources private constructor(private val items: List<TvShowEntity>) : PositionalDataSource<TvShowEntity>() {
        companion object {
            fun snapshot(items: List<TvShowEntity> = listOf()): PagedList<TvShowEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<TvShowEntity>) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<TvShowEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}