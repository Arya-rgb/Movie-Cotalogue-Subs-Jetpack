package com.thorin.moviecotalogue.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class MovieEntity (
    var movieId: String,
    var movieName: String,
    var movieRelease: String,
    var movieRate: String,
    var movieDescription: String,
    var movieGenre: String,
    var movieLocation: String,
    var imagePath: String
    ) : Parcelable
