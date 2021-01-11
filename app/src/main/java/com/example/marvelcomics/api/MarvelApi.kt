package com.example.marvelcomics.api

import com.example.marvelcomics.model.Comics
import retrofit2.Response
import retrofit2.http.GET


interface MarvelApi {

    @GET("comics")
    suspend fun comics() : Response<Comics>
}