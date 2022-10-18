package com.example.movietopia.model.utils.response.UserReview

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultUserReview(
    @field:SerializedName("id")
    var id: Long = 0L,

    @field:SerializedName("page")
    var page: Long = 0L,

    @field:SerializedName("results")
    var result: List<DataUserReview>?= null,

    @field:SerializedName("total_pages")
    var total_pages: Long = 0L,

    @field:SerializedName("total_results")
    var total_results: Long = 0L
): Parcelable