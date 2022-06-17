package com.example.foodish.network.api

import com.example.foodish.network.response.Breed
import com.example.foodish.network.response.FruitDrink
import retrofit2.Call
import retrofit2.http.GET

/**
 * Accounts API interface
 */
interface APIInterface {

    @GET("v1/breeds")
    fun getCatBreeds(): Call<List<Breed>>

    @GET("v1/breeds")
    fun getFruitDrinks(): Call<List<FruitDrink>>

}