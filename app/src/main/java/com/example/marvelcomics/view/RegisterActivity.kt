package com.example.marvelcomics.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelcomics.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)



        /*btLogin.setOnClickListener(){
            val intent = Intent(this, RestaurantActivity::class.java)
            startActivity(intent)
        }*/

    }


}