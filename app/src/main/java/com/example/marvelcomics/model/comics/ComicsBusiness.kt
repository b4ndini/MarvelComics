package com.example.marvelcomics.model.comics

import com.example.marvelcomics.api.ResponseApi

//classe não é mais necessária no paging
class ComicsBusiness {

    private val repo: ComicsRepository by lazy{
        ComicsRepository()
    }




/*

    suspend fun getComics() : ResponseApi {
        return repo.getComics()

    }
*/


}