package com.example.movietopia.view.page

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.movietopia.databinding.ActivityDetailBinding
import com.example.movietopia.model.utils.Object.NETWORKING.Companion.IMAGE_URL
import com.example.movietopia.model.utils.Object.convertListNumIntoListMovie
import com.example.movietopia.model.utils.Object.convertListStringIntoString
import com.example.movietopia.model.utils.response.DataMovie.DataMovieResponse

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val TAG = DetailActivity::class.java.simpleName
    private lateinit var dataMovieResponse: DataMovieResponse

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
        setUpInfoDisplay()
    }

    private fun setUpBundle(){
        dataMovieResponse = intent.getParcelableExtra(EXTRA_ITEM)!!
        Log.d(TAG, "item Delivered : ${dataMovieResponse}")
    }

    private fun setUpInfoDisplay(){
        binding.tvTitleMovie.text = dataMovieResponse.title
        binding.tvReleaseMovie.text = dataMovieResponse.release_date
        binding.tvVoteMovie.text = dataMovieResponse.vote_average.toString()
        binding.tvOverviewMovie.text = dataMovieResponse.overview

        //Vote
//        var genreText = convertListStringIntoString(convertListNumIntoListMovie(dataMovieResponse.genre_ids))

        val genreText = dataMovieResponse.genre_ids?.let {
            convertListStringIntoString(convertListNumIntoListMovie(it))
        }

        binding.tvGenreMovie.text = genreText

        val uriPoster = IMAGE_URL+dataMovieResponse.poster_path
        val uriBackdrop = IMAGE_URL+dataMovieResponse.backdrop_path

        Glide.with(this@DetailActivity)
            .load(uriPoster)
            .into(binding.ivPosterMovie)

        Glide.with(this@DetailActivity)
            .load(uriBackdrop)
            .into(binding.ivBackdropMovie)
    }
}