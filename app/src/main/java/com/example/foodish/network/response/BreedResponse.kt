package com.example.foodish.network.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Breed(

    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: BreedImage
): Serializable

data class BreedImage(
    @SerializedName("height") val height: String,
    @SerializedName("id") val id: String,
    @SerializedName("url") val url: String,
    @SerializedName("width") val width: String
) :Serializable


