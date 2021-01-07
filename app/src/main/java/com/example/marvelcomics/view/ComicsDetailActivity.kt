package com.example.marvelcomics.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelcomics.databinding.ActivityComicsDetailBinding

class ComicsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ivComics.setOnClickListener(){
            val intent = Intent(this, ComicsPictureActivity::class.java)
            startActivity(intent)
        }
    }

}