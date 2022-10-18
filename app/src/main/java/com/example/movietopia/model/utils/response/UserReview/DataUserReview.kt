package com.example.movietopia.model.utils.response.UserReview

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataUserReview(
    @field:SerializedName("author")
    var author: String = "",

    @field:SerializedName("author_detail")
    var author_detail: DataUserDetail ?= null,

    @field:SerializedName("content")
    var content: String = "",

    @field:SerializedName("created_at")
    var created_at: String = "",

    @field:SerializedName("id")
    var id: String = "",

    @field:SerializedName("updated_at")
    var updated_at: String = "",

    @field:SerializedName("url")
    var url: String = ""
): Parcelable