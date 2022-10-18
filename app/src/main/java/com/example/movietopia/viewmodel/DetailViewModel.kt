package com.example.movietopia.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movietopia.model.networking.ApiConfig
import com.example.movietopia.model.utils.response.DataVideoMovie.DataVideoMovieResponse
import com.example.movietopia.model.utils.response.DataVideoMovie.ResultVideoMovieResponse
import com.example.movietopia.model.utils.response.UserReview.DataUserReview
import com.example.movietopia.model.utils.response.UserReview.ResultUserReview
import retrofit2.Call
import retrofit2.Response

class DetailViewModel: ViewModel() {
    private val TAG = DetailViewModel::class.java.simpleName

    private var _resultVideo = MutableLiveData<ResultVideoMovieResponse>()
    val resultVideo : LiveData<ResultVideoMovieResponse> = _resultVideo

    private var _dataVideo = MutableLiveData<DataVideoMovieResponse>()
    val dataVideo : LiveData<DataVideoMovieResponse> = _dataVideo


    private val _isGettingVideoLoading = MutableLiveData<Boolean>()
    val isGettingVideoLoading : LiveData<Boolean> = _isGettingVideoLoading

    private val _isGettingVideoFail = MutableLiveData<Boolean>()
    val isGettingVideoFail : LiveData<Boolean> = _isGettingVideoFail

    private var _resultUserReview = MutableLiveData<ResultUserReview>()
    val resultUserReview : LiveData<ResultUserReview> = _resultUserReview

    private var _listDataUserReview = MutableLiveData<List<DataUserReview>>()
    val listDataUserReview : LiveData<List<DataUserReview>> = _listDataUserReview

    private var _isGettingListUserReviewLoading = MutableLiveData<Boolean>()
    val isGettingListUserReviewLoading: LiveData<Boolean> = _isGettingListUserReviewLoading

    private var _isGettingListUserReviewFail = MutableLiveData<Boolean>()
    val isGettingListUserReviewFail: LiveData<Boolean> = _isGettingListUserReviewFail

    fun getVideoMovie(id: String){
        _isGettingVideoLoading.value = true
        val client = ApiConfig.getApiService().gettmdbPreviewVideo(id)
        client.enqueue(object: retrofit2.Callback<ResultVideoMovieResponse>{
            override fun onResponse(
                call: Call<ResultVideoMovieResponse>,
                response: Response<ResultVideoMovieResponse>
            ) {
                _isGettingVideoLoading.value = false
                if(response.isSuccessful){
                    _resultVideo.value = response.body()
                    _dataVideo.value = resultVideo.value?.results?.get(0)
                    Log.d(TAG, "dataVideo earned: ${dataVideo.value}")
                }else{
                    _isGettingVideoLoading.value = true
                    Log.e(TAG, "!response.isSuccessful: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResultVideoMovieResponse>, t: Throwable) {
                _isGettingVideoLoading.value = false
                _isGettingVideoFail.value = true
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    fun getMovieUserReview(id: String){
        _isGettingListUserReviewLoading.value = true
        val client = ApiConfig.getApiService().getmovieUserReview(id)
        client.enqueue(object: retrofit2.Callback<ResultUserReview>{
            override fun onResponse(
                call: Call<ResultUserReview>,
                response: Response<ResultUserReview>
            ) {
                _isGettingListUserReviewLoading.value = false
                if(response.isSuccessful){
                    _resultUserReview.value = response.body()
                    _listDataUserReview.value = resultUserReview.value?.result!!
                    Log.d(TAG, "response success earned")
                }else{
                    _isGettingListUserReviewFail.value = true
                    Log.e(TAG, "!response.isSuccessful: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResultUserReview>, t: Throwable) {
                _isGettingListUserReviewLoading.value = false
                _isGettingListUserReviewFail.value = true
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }
}