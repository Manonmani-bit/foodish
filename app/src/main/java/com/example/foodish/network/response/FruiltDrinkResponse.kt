package com.example.foodish.network.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FruitDrink(

    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("family") val family: String,
): Serializable


