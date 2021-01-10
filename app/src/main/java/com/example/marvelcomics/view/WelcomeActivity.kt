package com.example.marvelcomics.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.marvelcomics.databinding.ActivityWelcomeBinding
import com.example.marvelcomics.viewModel.WelcomeViewModel

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding
    private lateinit var viewModel: WelcomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)

        binding.btnLogin.setOnClickListener(){
            val intent = Intent(this, ComicsActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener(){
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }
}