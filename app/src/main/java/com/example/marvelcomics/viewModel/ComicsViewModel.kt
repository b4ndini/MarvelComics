package com.example.marvelcomics.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.api.ResponseApi
import com.example.marvelcomics.model.Comics
import com.example.marvelcomics.model.comics.ComicsBusiness
import kotlinx.coroutines.launch

class   ComicsViewModel : ViewModel(){

    val comicsLiveData: MutableLiveData<Comics> = MutableLiveData()
    val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()

    private val comicsBusiness = ComicsBusiness()

    fun getComics(){

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


    }

}