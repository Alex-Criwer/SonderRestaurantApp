package com.example.sonder_restaurant.features.mainScreen.data.retrofit.entities

import com.google.gson.annotations.SerializedName

data class MenuItem (
    @SerializedName("dish_name")
    val dish_name: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("is_favourite")
    val is_favourite: Boolean
)