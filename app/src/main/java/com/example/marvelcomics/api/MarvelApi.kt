package com.example.marvelcomics.api

import com.example.marvelcomics.model.Comics
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface MarvelApi {

    @GET("comics")
    suspend fun comics(
    @Query("limit") limite : Int = 100
    ): Response<Comics>


}