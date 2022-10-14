package com.example.movietopia.view.page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.movietopia.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashScreenBinding
    private val TAG = SplashScreenActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        //Splash Screen Process
        setUpSplashProcess()
    }

    private fun setUpSplashProcess(){
        Handler().postDelayed(
            {
                startActivity(HomeActivity.newIntent(this@SplashScreenActivity))
                finish()
            }, 4000)
    }
}