package com.example.movietopia.view.page

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movietopia.R
import com.example.movietopia.databinding.ActivityHomeBinding
import com.example.movietopia.model.utils.Object.getListMovieNowPlaying
import com.example.movietopia.view.adapter.DummyMovieAdapter
import com.example.movietopia.view.advanced_ui.CustomTitle

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val TAG = HomeActivity::class.java.simpleName

    companion object{
        fun newIntent(context: Context): Intent = Intent(context, HomeActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNowPlayingView()
    }

    private fun setNowPlayingView(){
        binding.ctNowPlaying.apply {
            setTitle("Now Playing")
            setListener(object: CustomTitle.SeeAllListener{
                override fun onSeeAllSelected() {
                    Toast.makeText(this@HomeActivity, "See All Implemented Soon", Toast.LENGTH_SHORT).show()
                }
            })
        }

        binding.rvNowPlaying.apply {
            adapter = DummyMovieAdapter(getListMovieNowPlaying(), object: DummyMovieAdapter.onItemClickCallback{
                override fun onSelectedItem() {
                    Toast.makeText(this@HomeActivity, "Item Detail Implemented Soon", Toast.LENGTH_SHORT).show()
                }
            })
            layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}