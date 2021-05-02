package com.thorin.moviecotalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowResponse(
    var tvShowId: String,
    var tvShowName: String,
    var tvShowRelease: String,
    var tvShowRate: String,
    var tvShowDescription: String,
    var tvShowGenre: String,
    var tvShowLocation: String,
    var tvShowTotalEpisode: String,
    var imagePath: String
): Parcelable