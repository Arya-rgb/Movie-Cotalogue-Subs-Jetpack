package com.thorin.moviecotalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.data.source.remote.RemoteDataSource
import com.thorin.moviecotalogue.data.source.remote.response.MovieResponse
import com.thorin.moviecotalogue.data.source.remote.response.TvShowResponse

class FakeFilmRepository(private val remoteDataSource: RemoteDataSource) :
    FilmDataSource {

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movieResult = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMovieReceived(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponse) {
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
                movieResult.postValue(movieList)
            }

        })

        return movieResult
    }


    override fun getAllTvShow(): LiveData<List<TvShowEntity>> {
        val tvShowResult = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in tvShowResponse) {
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
                tvShowResult.postValue(tvShowList)
            }

        })

        return tvShowResult
    }

    override fun getMoviesDetail(movieId: String): LiveData<MovieEntity> {
        val movieDetailResult = MutableLiveData<MovieEntity>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMovieReceived(movieResponse: List<MovieResponse>) {
                lateinit var movie: MovieEntity
                for (response in movieResponse) {
                    if (response.movieId == movieId) {
                        movie = MovieEntity(
                            response.movieId,
                            response.movieName,
                            response.movieRelease,
                            response.movieRate,
                            response.movieDescription,
                            response.movieGenre,
                            response.movieLocation,
                            response.imagePath
                        )
                    }
                }
                movieDetailResult.postValue(movie)
            }

        })

        return movieDetailResult
    }

    override fun getTvShowDetail(tvShowId: String): LiveData<TvShowEntity> {
        val tvShowDetailResult = MutableLiveData<TvShowEntity>()

        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>) {
                lateinit var tvShow: TvShowEntity
                for (response in tvShowResponse) {
                    if (response.tvShowId == tvShowId) {
                        tvShow = TvShowEntity(
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
                    }
                }
                tvShowDetailResult.postValue(tvShow)
            }

        })

        return tvShowDetailResult
    }

}