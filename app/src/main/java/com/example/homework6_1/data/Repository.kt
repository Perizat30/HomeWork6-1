package com.example.homework6_1.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.homework6_1.data.model.CharactersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: CartoonApiService) {

    private val characters = MutableLiveData<CharactersResponse>()

    fun getCharacters(): MutableLiveData<CharactersResponse> {
       apiService.getCharacters().enqueue(object : Callback<CharactersResponse> {
            override fun onResponse(
                call: Call<CharactersResponse>,
                response: Response<CharactersResponse>
            ) {
                if (response.isSuccessful) {
                    val charactersResponse = response.body()
                    characters.postValue(charactersResponse!!)
                }
            }

            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                Log.e("onFailure", "${t.localizedMessage}")
            }
        })

        return characters
    }


}