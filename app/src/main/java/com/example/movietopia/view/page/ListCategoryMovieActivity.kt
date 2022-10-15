package com.example.movietopia.view.page

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movietopia.databinding.ActivityListCategoryMovieBinding
import com.example.movietopia.model.utils.Object.getListMovieNowPlaying
import com.example.movietopia.view.adapter.DummyMovieVerticalAdapter

class ListCategoryMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListCategoryMovieBinding
    private val TAG = ListCategoryMovieActivity::class.java.simpleName
    private var movieCategory: String = ""

    companion object{
        const val EXTRA_CATEGORY = "EXTRA_CATEGORY"
        fun newIntent(context: Context, category: String):Intent = Intent(context, ListCategoryMovieActivity::class.java).apply {
            putExtra(EXTRA_CATEGORY, category)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListCategoryMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView(){
        movieCategory = intent.getStringExtra(EXTRA_CATEGORY) as String

        supportActionBar?.title = movieCategory

        binding.rvListCategoryMovie.apply {
            adapter = DummyMovieVerticalAdapter(getListMovieNowPlaying(), object: DummyMovieVerticalAdapter.onItemClickCallback{
                override fun onSelectedItem() {
                    Toast.makeText(this@ListCategoryMovieActivity, "Detail Movie Implemented Soon", Toast.LENGTH_SHORT).show()
                }

            })

            layoutManager = LinearLayoutManager(this@ListCategoryMovieActivity)
        }
    }
}