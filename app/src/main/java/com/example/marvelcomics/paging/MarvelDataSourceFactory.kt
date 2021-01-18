package com.example.marvelcomics.paging

import androidx.lifecycle.MutableLiveData
import com.example.marvelcomics.model.Result
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource

class MarvelDataSourceFactory: DataSource.Factory<Int, Result>() {

    //creating the mutable live data
    private val marvelLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, Result>>()

    override fun create(): DataSource<Int, Result> {
        //getting our data source object
        val marvelDataSource = MarvelPageKeyedDataSource()

        //posting the datasource to get the values
        marvelLiveDataSource.postValue(marvelDataSource)

        //returning the datasource
        return marvelDataSource
    }

    //getter for itemlivedatasource
    fun getSearchLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, Result>> {
        return marvelLiveDataSource
    }
}