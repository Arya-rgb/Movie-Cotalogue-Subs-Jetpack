package com.thorin.moviecotalogue.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class TvShowEntity(
    var tvShowId: String,
    var tvShowName: String,
    var tvShowRelease: String,
    var tvShowRate: String,
    var tvShowDescription: String,
    var tvShowGenre: String,
    var tvShowLocation: String,
    var tvShowTotalEpisode: String,
    var imagePath: String
) : Parcelable