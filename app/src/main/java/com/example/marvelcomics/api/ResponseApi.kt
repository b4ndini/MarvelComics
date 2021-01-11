package com.example.marvelcomics.api

import com.example.marvelcomics.model.Comics

sealed  class ResponseApi {
    class Success(val dado: Comics?) : ResponseApi()
    class Error(val msg: String) : ResponseApi()


}