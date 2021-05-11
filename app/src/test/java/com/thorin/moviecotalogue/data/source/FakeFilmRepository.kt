package com.thorin.moviecotalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.NetworkBoundResource
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.data.source.local.LocalDataSource
import com.thorin.moviecotalogue.data.source.remote.RemoteDataSource
import com.thorin.moviecotalogue.data.source.remote.response.ApiResponse
import com.thorin.moviecotalogue.data.source.remote.response.MovieResponse
import com.thorin.moviecotalogue.data.source.remote.response.TvShowResponse
import com.thorin.moviecotalogue.utils.AppExecutors
import com.thorin.moviecotalogue.vo.Resource

class FakeFilmRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    FilmDataSource {

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {

            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.movieName,
                        response.movieRelease,
                        response.movieRate,
                        response.movieDescription,
                        response.movieGenre,
                        response.movieLocation,
                        response.imagePath
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMoviesList(movieList)
            }
        }.asLiveData()
    }


    override fun getAllTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> {

        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse>>(appExecutors) {

            public override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShow(), config).build()
            }


            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getAllTvShow()

            override fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvShow = TvShowEntity(
                        response.tvShowId,
                        response.tvShowName,
                        response.tvShowRelease,
                        response.tvShowRate,
                        response.tvShowDescription,
                        response.tvShowGenre,
                        response.tvShowLocation,
                        response.tvShowTotalEpisode,
                        response.imagePath
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShowList(tvShowList)
            }
        }.asLiveData()
    }

    override fun getMoviesDetail(movieId: String): LiveData<Resource<MovieEntity>> {

        return object : NetworkBoundResource<MovieEntity, List<MovieResponse>>(appExecutors) {

            public override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getDetailMovieById(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data?.movieId == null || data.movieId.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.movieName,
                        response.movieRelease,
                        response.movieRate,
                        response.movieDescription,
                        response.movieGenre,
                        response.movieLocation,
                        response.imagePath
                    )
                    movieList.add(movie)
                }
            }
        }.asLiveData()
    }

    override fun getTvShowDetail(tvShowId: String): LiveData<Resource<TvShowEntity>> {

        return object : NetworkBoundResource<TvShowEntity, List<TvShowResponse>>(appExecutors) {

            public override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getDetailTvShowById(tvShowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data?.tvShowId == null || data.tvShowId.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getAllTvShow()

            override fun saveCallResult(data: List<TvShowResponse>) {
                val movieList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvShow = TvShowEntity(
                        response.tvShowId,
                        response.tvShowName,
                        response.tvShowRelease,
                        response.tvShowRate,
                        response.tvShowDescription,
                        response.tvShowGenre,
                        response.tvShowLocation,
                        response.tvShowTotalEpisode,
                        response.imagePath
                    )
                    movieList.add(tvShow)
                }
            }
        }.asLiveData()
    }

    override fun setFavoriteMovie(movie: MovieEntity) {
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movie) }
    }

    override fun setMovieFavorite(movie: MovieEntity, NewState: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, NewState) }
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }


    override fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShow(), config).build()
    }

    override fun getAllMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getAllMovie(), config).build()
    }

    override fun getAllTvShows(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getAllTvShow(), config).build()
    }

    override fun setTvShowFavorite(tvShow: TvShowEntity, NewState: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(tvShow, NewState) }
    }

    override fun getDetailTvShowById(tvShowId: String) : LiveData<TvShowEntity> =
        localDataSource.getDetailTvShowById(tvShowId)

    override fun getDetailMovieById(movieId: String): LiveData<MovieEntity> =
        localDataSource.getDetailMovieById(movieId)

}
