package com.example.marvelcomics.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.marvelcomics.databinding.ActivityComicsPictureBinding
import com.example.marvelcomics.utils.Constants.Api.IMAGE_FULLSIZE

class ComicsPictureActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicsPictureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicsPictureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var imageFullSize = intent.getStringExtra("Image")
        imageFullSize += ".jpg"

        Glide.with(this).load( imageFullSize).into(binding.ivFullSizePicture)

        binding.ivClose.setOnClickListener{
            finish()
        }




    }
}