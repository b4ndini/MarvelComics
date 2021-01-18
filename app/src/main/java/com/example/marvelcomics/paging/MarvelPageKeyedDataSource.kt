package com.example.marvelcomics.paging

import androidx.paging.PageKeyedDataSource
import com.example.marvelcomics.api.ResponseApi
import com.example.marvelcomics.model.Comics
import com.example.marvelcomics.model.Result
import com.example.marvelcomics.model.comics.ComicsRepository
import com.example.marvelcomics.utils.Constants.Api.offset
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

//essa classe será a business
class MarvelPageKeyedDataSource : PageKeyedDataSource<Int, Result>() {

    private val repository by lazy{
        ComicsRepository()
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Result>
    ) {
        CoroutineScope(IO).launch {
            when(val response = repository.getComics(offset)){
                is ResponseApi.Success -> {
                    val data  = response.dado as Comics
                    callback.onResult(data.data.results, null, offset+20)
                }
                is ResponseApi.Error ->{
                    callback.onResult(mutableListOf(), null, offset+20)
                }
            }

        }
    }




    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        val page = params.key

        CoroutineScope(IO).launch {
            when(val response = repository.getComics(page)) {
                is ResponseApi.Success -> {
                    val data = response.dado as Comics
                    /*  data.data.results.forEach {
                          it.posterPath = it.posterPath.getFullImagePath()
                      }*/

                    callback.onResult(data.data.results, page-20)
                }
                is ResponseApi.Error -> {
                    callback.onResult(mutableListOf(), page-20)
                }
            }
        }
    }



    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        val page = params.key

        CoroutineScope(IO).launch {
            when(val response = repository.getComics(page)) {
                is ResponseApi.Success -> {
                    val data = response.dado as Comics
                    callback.onResult(data.data.results, page+20)
                }
                is ResponseApi.Error -> {
                    callback.onResult(mutableListOf(), page+20)
                }
            }
        }
    }

}