package com.example.marvelcomics.api

import com.example.marvelcomics.model.Comics
import retrofit2.Response
import retrofit2.http.GET

interface MarvelApi {

    @GET("v1/public/comics?ts=1609720849492&apikey=6eb7e8896ec5850c52515a8a23ee97f0&hash=a0d686e3809e37740dd25713d34597d8")
    suspend fun comics() : Response<Comics>
}