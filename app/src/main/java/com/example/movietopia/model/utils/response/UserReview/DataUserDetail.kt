package com.example.movietopia.model.utils.response.UserReview

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataUserDetail(
    @field:SerializedName("name")
    var name: String = "",

    @field:SerializedName("username")
    var username: String = "",

    @field:SerializedName("avatar_path")
    var avatar_path: String = "",

    @field:SerializedName("rating")
    var rating: Double = 0.0
): Parcelable