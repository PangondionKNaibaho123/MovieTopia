package com.example.movietopia.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movietopia.model.networking.ApiConfig
import com.example.movietopia.model.utils.response.DataMovie.DataMovieResponse
import com.example.movietopia.model.utils.response.DataMovie.ResultMovieResponse
import retrofit2.Call
import retrofit2.Response

class HomeViewModel: ViewModel() {
    private val TAG = HomeViewModel::class.java.simpleName

    private var _listMovie = MutableLiveData<List<DataMovieResponse>>()
    val listMovie : LiveData<List<DataMovieResponse>> = _listMovie

    private var _resultMovie = MutableLiveData<ResultMovieResponse>()
    val resultMovie : LiveData<ResultMovieResponse> = _resultMovie

    private var _listSearchedMovie = MutableLiveData<List<DataMovieResponse>>()
    val listSearchedMovie : LiveData<List<DataMovieResponse>> = _listSearchedMovie

    private var _resultSearchedMovie = MutableLiveData<ResultMovieResponse>()
    val resultSearchedMovie : LiveData<ResultMovieResponse> = _resultSearchedMovie

    private val _isFail = MutableLiveData<Boolean>()
    val isFail: LiveData<Boolean> = _isFail

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getMovieAll(){
        _isLoading.value = true
        val client1 = ApiConfig.getApiService().gettmdbMovie()
        client1.enqueue(object: retrofit2.Callback<ResultMovieResponse>{
            override fun onResponse(
                call: Call<ResultMovieResponse>,
                response: Response<ResultMovieResponse>
            ) {
                _isLoading.value = false
                if(response.isSuccessful){
                    _resultMovie.value = response.body()
                    _listMovie.value = resultMovie.value?.results!!
                    Log.d(TAG, "response success earned")
                }else{
                    _isFail.value = true
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResultMovieResponse>, t: Throwable) {
                _isLoading.value = false
                _isFail.value = true
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    fun getMoviebyGenre(genre: Int){
        _isLoading.value = true
        val client = ApiConfig.getApiService().gettmdbMoviebyGenre(with_genres = genre)
        client.enqueue(object: retrofit2.Callback<ResultMovieResponse>{
            override fun onResponse(
                call: Call<ResultMovieResponse>,
                response: Response<ResultMovieResponse>
            ) {
                _isLoading.value = false
                if(response.isSuccessful){
                    _resultSearchedMovie.value = response.body()
                    _listSearchedMovie.value = resultSearchedMovie.value?.results!!
                }else{
                    _isFail.value = true
                    Log.e(TAG, "!response.isSuccessful : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResultMovieResponse>, t: Throwable) {
                _isLoading.value = false
                _isFail.value = true
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }
}