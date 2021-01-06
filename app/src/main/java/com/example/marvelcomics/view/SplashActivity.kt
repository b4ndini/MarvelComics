package com.example.marvelcomics.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import com.example.marvelcomics.MainActivity
import com.example.marvelcomics.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {

    private val splashTimeout: Long = 8000
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigateToMainActivity()
    }

    private fun navigateToMainActivity() {
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, splashTimeout)
    }
}