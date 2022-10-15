package com.example.movietopia.model.utils

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DummyMovie (
    var movieName: String,
    var movieRate: Double,
    var movieYear: String
): Parcelable