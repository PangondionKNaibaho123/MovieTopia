package com.example.movietopia.model.networking.remote

import com.example.movietopia.BuildConfig
import com.example.movietopia.model.utils.Object.NETWORKING.Companion.API_KEY
import com.example.movietopia.model.utils.response.ResultMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //Getting Movie
    @GET("3/discover/movie")
    fun gettmdbMovie(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int = 1
    ): Call<ResultMovieResponse>

    //Getting Movie with certain genre
    @GET("3/discover/movie")
    fun gettmdbMoviebyGenre(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("with_genres") with_genres: Int,
        @Query("page") page: Int = 1
    ): Call<ResultMovieResponse>
}