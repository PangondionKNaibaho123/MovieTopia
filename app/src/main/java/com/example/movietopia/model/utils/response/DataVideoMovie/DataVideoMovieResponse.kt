package com.example.movietopia.model.utils.response.DataVideoMovie

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataVideoMovieResponse (
   @field:SerializedName("iso_639_1")
   var iso_639_1 : String = "",

   @field:SerializedName("isp_3166_1")
   var isp_3166_1: String = "",

   @field:SerializedName("name")
   var name: String = "",

   @field:SerializedName("key")
   var key: String = "",

   @field:SerializedName("site")
   var site: String = "",

   @field:SerializedName("type")
   var type: String = "",

   @field:SerializedName("official")
   var official: Boolean = false,

   @field:SerializedName("published_at")
   var published_at: String = "",

   @field:SerializedName("id")
   var id: String = ""
): Parcelable