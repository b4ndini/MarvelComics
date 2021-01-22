package com.example.marvelcomics.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.marvelcomics.databinding.ActivityComicsDetailBinding
import com.example.marvelcomics.model.Result
import com.example.marvelcomics.utils.Constants.Api.IMAGE_SIZE_LARGE
import com.example.marvelcomics.utils.Constants.Api.LANDSCAPE_SIZE_INCREDIBLE


class ComicsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicsDetailBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


       var comics = intent.getParcelableExtra<Result>("comicss")

        binding.tvComicsTitle.text = comics?.title ?: "No title"
        binding.tvComicsSummary.text = comics?.description ?: "There's no description for this comics"

        if(comics?.pageCount != 0) {
            binding.tvPages.text = "Pages: " + comics?.pageCount.toString() ?: "Pages: Not specified"
        }else{ binding.tvPages.text = "Pages: Not specified"}

        val image : String = (comics?.thumbnail?.path) + IMAGE_SIZE_LARGE + (comics?.thumbnail?.extension)
        Glide.with(this).load(image).into(binding.ivComics)

        if(comics?.prices?.get(0)?.price != 0.0) {
            binding.tvPrice.text = "Price: $ " + comics?.prices?.get(0)?.price.toString() ?: "Price: Not specified"
        }else{binding.tvPrice.text = "Price: Not specified"}



        binding.tvPublished.text = "Published: " + comics?.dates?.get(0)?.date.toString().substring(
            0,
            9
        ) ?: "Published: Not specified"


        val backgroundImage : String = (comics?.thumbnail?.path) + LANDSCAPE_SIZE_INCREDIBLE + (comics?.thumbnail?.extension)
        Glide.with(this).load(backgroundImage).into(binding.ivBackgroundImage)

        val imageFull = comics?.thumbnail?.path


        binding.ivBackgroundImage.setOnClickListener{
            val intent = Intent(this@ComicsDetailActivity, ComicsPictureActivity::class.java)
            intent.putExtra("Image", imageFull)
            startActivity(intent)
        }

        binding.ivSeta.setOnClickListener{
            finish()
        }


        Log.i("teste", "ID DO ITEM É $comics.id")


    }

}