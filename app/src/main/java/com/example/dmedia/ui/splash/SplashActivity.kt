package com.example.dmedia.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.dmedia.R
import com.example.dmedia.databinding.ActivitySplashBinding
import com.example.dmedia.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                val i = Intent(this@SplashActivity, HomeActivity::class.java)
                startActivity(i)
            }
        }, 3000)

    }
}