package com.example.foodish.modules.home.breed.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.foodish.network.RetrofitHub
import com.example.foodish.network.response.Breed
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BreedRepository {

    private var breedList: List<Breed> = listOf()

    fun getBreeds(): List<Breed> {

        val call = RetrofitHub.apiInterface.getCatBreeds()

        call.enqueue(object : Callback<List<Breed>> {
            override fun onFailure(call: Call<List<Breed>>, t: Throwable) {
                Log.d("xxx failed", "Failed :" + t.message)
            }

            override fun onResponse(
                call: Call<List<Breed>>,
                response: Response<List<Breed>>
            ) {
                response.body()
                Log.d("xxx get response",  response.raw().toString());
                Log.d("xxx get response",  response.body().toString());
                breedList = response.body()!!
            }
        })
        return breedList
    }
}