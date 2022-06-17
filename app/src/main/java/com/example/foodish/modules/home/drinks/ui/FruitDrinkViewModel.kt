package com.example.foodish.modules.home.breed.data.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.foodish.common.BaseViewModel
import com.example.foodish.modules.home.breed.data.FruitDrinkRepository
import com.example.foodish.network.RetrofitHub
import com.example.foodish.network.response.Breed
import com.example.foodish.network.response.FruitDrink
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FruitDrinkViewModel(application: Application) : BaseViewModel(application) {

    private val fruitDrinkRepository by lazy { FruitDrinkRepository() }

    val fruitDrinkList = MutableLiveData<List<FruitDrink>>()

    fun fetchBreedListDetails() {
        showProgress()
        val call = RetrofitHub.apiInterface.getFruitDrinks()
        call.enqueue(object : Callback<List<FruitDrink>> {

            override fun onFailure(call: Call<List<FruitDrink>>, t: Throwable) {
                hideProgress()
                Log.d("xxx failed", "Failed :" + t.message)
            }

            override fun onResponse(
                call: Call<List<FruitDrink>>,
                response: Response<List<FruitDrink>>
            ) {
                hideProgress()
                Log.d("xxx get fruit response",  response.body().toString());
                fruitDrinkList.value = response.body()!!
            }
        })
    }

}