package com.example.foodish.modules.home.breed.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.foodish.network.RetrofitHub
import com.example.foodish.network.response.Breed
import com.example.foodish.network.response.FruitDrink
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FruitDrinkRepository {

    private var fruitDrinkList: List<FruitDrink> = listOf()

    fun getFruitDrinks(): List<FruitDrink> {

        val call = RetrofitHub.apiInterface.getFruitDrinks()

        call.enqueue(object : Callback<List<FruitDrink>> {
            override fun onFailure(call: Call<List<FruitDrink>>, t: Throwable) {
                Log.d("xxx failed", "Failed :" + t.message)
            }

            override fun onResponse(
                call: Call<List<FruitDrink>>,
                response: Response<List<FruitDrink>>
            ) {
                response.body()
                Log.d("xxx get response",  response.raw().toString());
                Log.d("xxx get response",  response.body().toString());
                fruitDrinkList = response.body()!!
            }
        })
        return fruitDrinkList
    }
}