package com.example.movietopia.model.utils.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultMovieResponse (
        @field:SerializedName("page")
        var page: Int = 0,

        @field: SerializedName("results")
        var results: List<DataMovieResponse> ?= null,

        @field: SerializedName("total_pages")
        var total_pages: Long = 0L,

        @field: SerializedName("total_results")
        var total_results: Long = 0L
) : Parcelable