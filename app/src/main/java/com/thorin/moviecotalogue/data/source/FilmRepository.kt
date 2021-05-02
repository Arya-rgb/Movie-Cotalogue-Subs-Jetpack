package com.thorin.moviecotalogue.data.source

import com.thorin.moviecotalogue.data.MovieEntity
import com.thorin.moviecotalogue.data.TvShowEntity
import com.thorin.moviecotalogue.data.source.remote.RemoteDataSource

class FilmRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    FilmDataSource {

    companion object {
        @Volatile
        private var instance: FilmRepository? = null

        fun getInstance(remoteData: RemoteDataSource): FilmRepository =
            instance ?: synchronized(this) {
                instance ?: FilmRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovies(): ArrayList<MovieEntity> {
        val movieResponses = remoteDataSource.getAllMovies()
        val movieList = ArrayList<MovieEntity>()
        for (response in movieResponses) {
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
        return movieList
    }

    override fun getAllTvShow(): ArrayList<TvShowEntity> {
        val tvShowResponse = remoteDataSource.getAllTvShow()
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
        return tvShowList
    }

    override fun getMoviesDetail(movieId: String): MovieEntity {
        val movieResponse = remoteDataSource.getAllMovies()
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
        return movie
    }

    override fun getTvShowDetail(tvShowId: String): TvShowEntity {
        val tvShowResponse = remoteDataSource.getAllTvShow()
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
        return tvShow
    }

}