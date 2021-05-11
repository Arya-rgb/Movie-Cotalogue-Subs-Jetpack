package com.thorin.moviecotalogue.data

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tvShow_entities")
class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: String,

    @ColumnInfo(name = "tvShowName")
    var tvShowName: String,

    @ColumnInfo(name = "tvShowRelease")
    var tvShowRelease: String,

    @ColumnInfo(name = "tvShowRate")
    var tvShowRate: String,

    @ColumnInfo(name = "tvShowDescription")
    var tvShowDescription: String,

    @ColumnInfo(name = "tvShowGenre")
    var tvShowGenre: String,

    @ColumnInfo(name = "tvShowLocation")
    var tvShowLocation: String,

    @ColumnInfo(name = "tvShowTotalEpisode")
    var tvShowTotalEpisode: String,

    @ColumnInfo(name = "imagePath")
    var imagePath: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false

) : Parcelable