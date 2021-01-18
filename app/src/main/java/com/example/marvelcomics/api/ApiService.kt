package com.example.marvelcomics.api


import com.example.marvelcomics.utils.Constants.Api.BASE_URL
import com.example.marvelcomics.utils.Constants.Api.PRIVATE_KEY
import com.example.marvelcomics.utils.Constants.Api.PUBLIC_KEY
import com.example.marvelcomics.utils.md5
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import java.util.*


 object ApiService  {

    val marvelApi = getMarvelApiClient().create(MarvelApi::class.java)


    private fun getInterceptorClient(): OkHttpClient {
        val timeStamp = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val interceptor  = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor{chain ->

                val newReques = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("ts", timeStamp)
                    .addQueryParameter("apikey", PUBLIC_KEY)
                    .addQueryParameter("hash", "$timeStamp$PRIVATE_KEY$PUBLIC_KEY".md5())
                    .build()


                chain.proceed(chain.request().newBuilder().url(newReques).build())

            }
        return interceptor.build()
    }

    private fun getMarvelApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getInterceptorClient())                                //retorna o getInterceptor
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}