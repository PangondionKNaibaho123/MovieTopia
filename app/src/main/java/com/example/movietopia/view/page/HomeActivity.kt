package com.example.movietopia.view.page

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movietopia.databinding.ActivityHomeBinding
import com.example.movietopia.model.utils.Object.MOVIE_CATEGORY.Companion.NOW_PLAYING
import com.example.movietopia.model.utils.Object.getListMovie
import com.example.movietopia.model.utils.response.DataMovieResponse
import com.example.movietopia.model.utils.response.ResultMovieResponse
import com.example.movietopia.view.adapter.DummyMovieHorizontalAdapter
import com.example.movietopia.view.adapter.DummyMovieVerticalAdapter
import com.example.movietopia.view.adapter.MovieAdapter
import com.example.movietopia.view.advanced_ui.CustomTitle
import com.example.movietopia.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val TAG = HomeActivity::class.java.simpleName

    private val homeViewModel by viewModels<HomeViewModel>()
    private var arrListMovie = ArrayList<DataMovieResponse>()

    companion object{
        fun newIntent(context: Context): Intent = Intent(context, HomeActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setListMovieView()

        binding.rvMovie.setHasFixedSize(true)
        binding.rvMovie.layoutManager = LinearLayoutManager(this)

        homeViewModel.getMovieAll()
        homeViewModel.listMovie.observe(this, {listMovie ->
            setMovieList(listMovie)
        })

        homeViewModel.isLoading.observe(this, {
            showLoading(it)
        })

        homeViewModel.isFail.observe(this, {
            setUpWarning(it)
        })
    }

    private fun setMovieList(listMovie: List<DataMovieResponse>){
        val adapter = MovieAdapter(listMovie, object: MovieAdapter.onItemClickCallback{
            override fun onSelectedItem(item: DataMovieResponse) {
                Log.d(TAG, "item: $item")
                Toast.makeText(this@HomeActivity, "Detail of ${item.title} implemented soon", Toast.LENGTH_SHORT).show()
            }

        })
        binding.rvMovie.adapter = adapter
    }

    private fun showLoading(isLoading: Boolean){
        binding.pbHome.visibility = if(isLoading) View.VISIBLE else View.GONE
    }

    private fun setUpWarning(isFail: Boolean){
        if(isFail){
            Toast.makeText(this@HomeActivity, "We're Sorry, a failure happen for a while", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setListMovieView(){
        binding.rvMovie.apply {
            adapter = DummyMovieVerticalAdapter(getListMovie(), object: DummyMovieVerticalAdapter.onItemClickCallback{
                override fun onSelectedItem() {
                    Toast.makeText(this@HomeActivity, "Detail Movie Implemented soon", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}