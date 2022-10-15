package com.example.movietopia.model.utils

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DummyMovie (
    var movieName: String = "",
    var movieRate: Double = 0.0,
    var movieYear: String = "",
    var movieDesc: String = "",
    var movieImgUrl: String = ""
): Parcelable