package com.example.marvelcomics.model

import com.google.gson.annotations.SerializedName

data class Comics(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    @SerializedName("data")
    val data: Data,
    val etag: String,
    val status: String
)