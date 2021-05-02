package com.thorin.moviecotalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    var movieId: String,
    var movieName: String,
    var movieRelease: String,
    var movieRate: String,
    var movieDescription: String,
    var movieGenre: String,
    var movieLocation: String,
    var imagePath: String
) : Parcelable