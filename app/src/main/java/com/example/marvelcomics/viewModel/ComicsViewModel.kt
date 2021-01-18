package com.example.marvelcomics.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.marvelcomics.api.ResponseApi
import com.example.marvelcomics.model.Comics
import com.example.marvelcomics.model.Result
import com.example.marvelcomics.model.comics.ComicsBusiness
import com.example.marvelcomics.paging.MarvelDataSourceFactory
import kotlinx.coroutines.launch

class   ComicsViewModel : ViewModel(){



    var comicsPagedList : LiveData<PagedList<Result>>? = null
    private var marvelLiveDataSource: LiveData<PageKeyedDataSource<Int, Result>>? = null

   init{
        val marvelDataSourceFactory = MarvelDataSourceFactory()

        marvelLiveDataSource = marvelDataSourceFactory.getSearchLiveDataSource()

        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20).build()


            comicsPagedList = LivePagedListBuilder(marvelDataSourceFactory, pagedListConfig).build()
    }

  /*  val comicsLiveData: MutableLiveData<Comics> = MutableLiveData()
    val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()

    private val comicsBusiness = ComicsBusiness()*/



 /*   fun getComics(){

        viewModelScope.launch{
        when(val response = comicsBusiness.getComics()){
                is ResponseApi.Success -> {
                    comicsLiveData.postValue(response.dado as? Comics )
                }
                is ResponseApi.Error -> {
                    errorMessageLiveData.postValue(response.msg)
                }
            }

        }


    }*/

}