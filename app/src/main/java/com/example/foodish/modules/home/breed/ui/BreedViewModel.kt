package com.example.foodish.modules.home.breed.data.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.foodish.common.BaseViewModel
import com.example.foodish.modules.home.breed.data.FruitDrinkRepository
import com.example.foodish.network.RetrofitHub
import com.example.foodish.network.response.Breed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BreedViewModel(application: Application) : BaseViewModel(application) {

    private val breedRepository by lazy { FruitDrinkRepository() }

    val breedList = MutableLiveData<List<Breed>>()

    fun fetchBreedListDetails() {
        showProgress()
        val call = RetrofitHub.apiInterface.getCatBreeds()
        call.enqueue(object : Callback<List<Breed>> {

            override fun onFailure(call: Call<List<Breed>>, t: Throwable) {
                hideProgress()
                Log.d("xxx failed", "Failed :" + t.message)
            }

            override fun onResponse(
                call: Call<List<Breed>>,
                response: Response<List<Breed>>
            ) {
                hideProgress()
                Log.d("xxx get response",  response.body().toString());
                breedList.value = response.body()!!
            }
        })
    }

}