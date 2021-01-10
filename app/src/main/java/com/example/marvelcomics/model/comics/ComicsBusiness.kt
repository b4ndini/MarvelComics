package com.example.marvelcomics.model.comics

import com.example.marvelcomics.api.ResponseApi

class ComicsBusiness {

    private val repo: ComicsRepository by lazy{
        ComicsRepository()
    }





    suspend fun getComics() : ResponseApi {
        return repo.getComics()

    }


    /*fun getComics() : List<Comics>{
       return repo.getComics()

   }*/

}