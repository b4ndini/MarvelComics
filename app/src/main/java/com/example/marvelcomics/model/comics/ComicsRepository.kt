package com.example.marvelcomics.model.comics

import com.example.marvelcomics.api.ApiService
import com.example.marvelcomics.api.ResponseApi

class ComicsRepository {

    suspend fun getComics(): ResponseApi {

          return  try{
                val response = ApiService.marvelApi.comics()

                if(response.isSuccessful){
                    ResponseApi.Success(response.body())
                }
                else{
                    ResponseApi.Error("Não foi possível carregar os dados")
                }
            }catch(exception: Exception){
                ResponseApi.Error("Caiu no catch")
            }
        /*val quadrinhos = mutableListOf<Comics>()

        val c1 = Comics("asd")
        val c2 = Comics("fgh")
        val c3 = Comics("jkl")
        val c4 = Comics("zxc")
        val c5 = Comics("wer")
        val c6 = Comics("123")
        val c7 = Comics("456")
        val c8 = Comics("678")
        val c9 = Comics("90-")

        quadrinhos.add(c1)
        quadrinhos.add(c2)
        quadrinhos.add(c3)
        quadrinhos.add(c4)
        quadrinhos.add(c5)
        quadrinhos.add(c6)
        quadrinhos.add(c7)
        quadrinhos.add(c8)
        quadrinhos.add(c9)

        return quadrinhos*/

    }
}