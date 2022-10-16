package com.example.movietopia.model.networking.remote

import com.example.movietopia.BuildConfig
import com.example.movietopia.model.utils.Object.NETWORKING.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
   companion object{
       fun getApiService(): ApiService{
           val loggingInterceptor = if(BuildConfig.DEBUG){
               HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
           }else{
               HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
           }
           val client = OkHttpClient.Builder()
               .addInterceptor(loggingInterceptor)
               .build()
           val retrofit = Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .client(client)
               .build()

           return retrofit.create(ApiService::class.java)
       }
   }
}