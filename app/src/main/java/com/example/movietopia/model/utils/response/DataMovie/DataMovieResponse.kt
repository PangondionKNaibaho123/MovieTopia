package com.example.movietopia.model.utils.response.DataMovie

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataMovieResponse (
    @field:SerializedName("adult")
    var adult: Boolean = false,

    @field:SerializedName("backdrop_path")
    var backdrop_path: String = "",

    @field:SerializedName("genre_ids")
    var genre_ids: List<Int> ?= null,

    @field:SerializedName("id")
    var id: Long = 0L,

    @field:SerializedName("original_language")
    var original_language: String = "",

    @field:SerializedName("overview")
    var overview: String = "",

    @field:SerializedName("popularity")
    var popularity: Double = 0.0,

    @field:SerializedName("poster_path")
    var poster_path: String = "",

    @field:SerializedName("release_date")
    var release_date: String = "",

    @field:SerializedName("title")
    var title: String = "",

    @field:SerializedName("video")
    var video: Boolean = false,

    @field:SerializedName("vote_average")
    var vote_average: Double = 0.0,

    @field:SerializedName("vote_count")
    var vote_count: Long = 0L
): Parcelable