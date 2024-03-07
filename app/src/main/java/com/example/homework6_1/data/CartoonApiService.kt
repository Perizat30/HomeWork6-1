package com.example.homework6_1.data

import retrofit2.Call
import retrofit2.http.GET
import com.example.homework6_1.data.model.CharactersResponse

interface CartoonApiService {
    @GET("character")
    fun getCharacters(): Call<CharactersResponse>

}