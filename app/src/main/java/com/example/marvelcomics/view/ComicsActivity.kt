package com.example.marvelcomics.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelcomics.databinding.ActivityComicsBinding

class ComicsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ivActionBar.setOnClickListener(){
            val intent = Intent(this, ComicsDetailActivity::class.java)
            startActivity(intent)
        }
    }
}