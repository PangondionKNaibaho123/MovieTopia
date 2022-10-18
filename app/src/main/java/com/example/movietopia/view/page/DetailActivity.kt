package com.example.movietopia.view.page

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movietopia.databinding.ActivityDetailBinding
import com.example.movietopia.model.utils.Object.NETWORKING.Companion.IMAGE_URL
import com.example.movietopia.model.utils.Object.NETWORKING.Companion.YOUTUBE_URL
import com.example.movietopia.model.utils.Object.convertListNumIntoListMovie
import com.example.movietopia.model.utils.Object.convertListStringIntoString
import com.example.movietopia.model.utils.response.DataMovie.DataMovieResponse
import com.example.movietopia.model.utils.response.DataVideoMovie.DataVideoMovieResponse
import com.example.movietopia.model.utils.response.UserReview.DataUserReview
import com.example.movietopia.view.adapter.UserReviewAdapter
import com.example.movietopia.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val TAG = DetailActivity::class.java.simpleName
    private lateinit var dataMovieResponse: DataMovieResponse

    private val detailViewModel by viewModels<DetailViewModel>()

    companion object{
        const val EXTRA_ITEM = "EXTRA_ITEM"
        fun newIntent(context: Context, itemDelivered: DataMovieResponse): Intent = Intent(context, DetailActivity::class.java)
            .putExtra(EXTRA_ITEM, itemDelivered)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBundle()
        setUpInfonOverviewDisplay()

        detailViewModel.getVideoMovie(dataMovieResponse.id.toString())

        detailViewModel.dataVideo.observe(this, {dataPreviewVideo ->
            setUpPreviewMovie(dataPreviewVideo)
        })

        detailViewModel.isGettingVideoLoading.observe(this,{
            showVideoLoading(it)
        })

        detailViewModel.isGettingVideoFail.observe(this, {
            setUpWarning(it)
        })

        binding.rvUserReview.setHasFixedSize(true)
        binding.rvUserReview.layoutManager = LinearLayoutManager(this)

        detailViewModel.getMovieUserReview(dataMovieResponse.id.toString())

        detailViewModel.listDataUserReview.observe(this, {listDataUserReview ->
            setUpUserReview(listDataUserReview)
        })

        detailViewModel.isGettingListUserReviewLoading.observe(this, {
            showUserReviewLoading(it)
        })

        detailViewModel.isGettingListUserReviewFail.observe(this, {
            setUpWarningUserReview(it)
        })

    }

    private fun setUpBundle(){
        dataMovieResponse = intent.getParcelableExtra(EXTRA_ITEM)!!
        Log.d(TAG, "item Delivered : ${dataMovieResponse}")
    }

    private fun setUpInfonOverviewDisplay(){
        binding.tvTitleMovie.text = dataMovieResponse.title
        binding.tvReleaseMovie.text = dataMovieResponse.release_date
        binding.tvVoteMovie.text = dataMovieResponse.vote_average.toString()
        binding.tvOverviewMovie.text = dataMovieResponse.overview

        val genreText = dataMovieResponse.genre_ids?.let {
            convertListStringIntoString(convertListNumIntoListMovie(it))
        }

        binding.tvGenreMovie.text = genreText

        val uriPoster = IMAGE_URL+dataMovieResponse.poster_path


        Glide.with(this@DetailActivity)
            .load(uriPoster)
            .into(binding.ivPosterMovie)

    }

    private fun setUpPreviewMovie(dataPreviewVideo: DataVideoMovieResponse){
        val uri = Uri.parse(YOUTUBE_URL+"/watch?v="+dataPreviewVideo.key)

        val uriBackdrop = IMAGE_URL+dataMovieResponse.backdrop_path

        Glide.with(this@DetailActivity)
            .load(uriBackdrop)
            .into(binding.ivPreviewMovie)

        binding.ivPreviewMovie.setOnClickListener {
            val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse(uri.toString()))
            startActivity(appIntent)
        }
        binding.ivPlayMovie.setOnClickListener {
            val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse(uri.toString()))
            startActivity(appIntent)
        }
    }

    private fun showVideoLoading(isGettingVideoLoading: Boolean){
        binding.pbPreviewMovie.visibility = if(isGettingVideoLoading) View.VISIBLE else View.GONE
        binding.ivPlayMovie.visibility = if(isGettingVideoLoading) View.GONE else View.VISIBLE
    }

    private fun setUpWarning(isGettingVideoFail: Boolean){
        if(isGettingVideoFail){
            Toast.makeText(this@DetailActivity, "We're sorry, failure happens when getting video", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setUpUserReview(listDataUserReview: List<DataUserReview>){
        val adapter = UserReviewAdapter(listDataUserReview)
        binding.rvUserReview.adapter = adapter
    }

    private fun showUserReviewLoading(isGettingUserReviewLoading: Boolean){
        binding.pbUserReview.visibility = if(isGettingUserReviewLoading) View.VISIBLE else View.GONE
    }

    private fun setUpWarningUserReview(isGettingUserReviewFail: Boolean){
        if(isGettingUserReviewFail){
//            binding.rvUserReview.visibility = View.GONE
            Toast.makeText(this@DetailActivity, "We're Sorry, a failure happen for a while", Toast.LENGTH_SHORT).show()
        }
    }

}