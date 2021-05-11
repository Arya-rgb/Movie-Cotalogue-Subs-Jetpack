package com.thorin.moviecotalogue.data

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "movie_entities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

    @ColumnInfo(name = "movieName")
    var movieName: String,

    @ColumnInfo(name = "movieRelease")
    var movieRelease: String,

    @ColumnInfo(name = "movieRate")
    var movieRate: String,

    @ColumnInfo(name = "movieDescription")
    var movieDescription: String,

    @ColumnInfo(name = "movieGenre")
    var movieGenre: String,

    @ColumnInfo(name = "movieLocation")
    var movieLocation: String,

    @ColumnInfo(name = "imagePath")
    var imagePath: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false

) : Parcelable
