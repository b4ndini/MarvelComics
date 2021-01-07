package com.example.marvelcomics.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelcomics.databinding.ActivityComicsPictureBinding

class ComicsPictureActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicsPictureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicsPictureBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}