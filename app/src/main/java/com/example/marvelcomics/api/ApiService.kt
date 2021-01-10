package com.example.marvelcomics.api

import com.example.marvelcomics.utils.Constants.Api.BASE_URL
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

object ApiService  {

    val marvelApi = getMarvelApiClient().create(MarvelApi::class.java)

    private fun getMarvelApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


}