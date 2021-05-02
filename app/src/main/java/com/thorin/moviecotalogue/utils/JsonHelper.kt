package com.thorin.moviecotalogue.utils

import android.content.Context
import android.util.Log
import com.thorin.moviecotalogue.data.source.remote.response.MovieResponse
import com.thorin.moviecotalogue.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponse.json").toString())
            val listArray = responseObject.getJSONArray("movie")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val movieId = movie.getString("movieId")
                val movieName = movie.getString("movieName")
                val movieRelease = movie.getString("movieRelease")
                val movieRate = movie.getString("movieRate")
                val movieDescription = movie.getString("movieDescription")
                val movieGenre = movie.getString("movieGenre")
                val movieLocation = movie.getString("movieLocation")
                val imagePath = movie.getString("imagePath")

                val movieResponse = MovieResponse(
                    movieId,
                    movieName,
                    movieRelease,
                    movieRate,
                    movieDescription,
                    movieGenre,
                    movieLocation,
                    imagePath
                )
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShow(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponse.json").toString())
            val listArray = responseObject.getJSONArray("tvShow")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val tvShowId = tvShow.getString("tvShowId")
                val tvShowName = tvShow.getString("tvShowName")
                val tvShowRelease = tvShow.getString("tvShowRelease")
                val tvShowRate = tvShow.getString("tvShowRate")
                val tvShowDescription = tvShow.getString("tvShowDescription")
                val tvShowGenre = tvShow.getString("tvShowGenre")
                val tvShowLocation = tvShow.getString("tvShowLocation")
                val tvShowTotalEpisode = tvShow.getString("tvShowTotalEpisode")
                val imagePath = tvShow.getString("imagePath")

                val tvShowResponse = TvShowResponse(
                    tvShowId,
                    tvShowName,
                    tvShowRelease,
                    tvShowRate,
                    tvShowDescription,
                    tvShowGenre,
                    tvShowLocation,
                    tvShowTotalEpisode,
                    imagePath
                )
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

}