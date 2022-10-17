package com.example.movietopia.model.utils.response.DataVideoMovie

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultVideoMovieResponse (
    @field:SerializedName("id")
    var id: Long = 0L,

    @field:SerializedName("results")
    var results: List<DataVideoMovieResponse> ?= null
): Parcelable