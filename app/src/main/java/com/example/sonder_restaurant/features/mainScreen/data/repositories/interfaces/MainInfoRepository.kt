package com.example.sonder_restaurant.features.mainScreen.data.repositories.interfaces

import com.example.sonder_restaurant.features.mainScreen.data.retrofit.entities.MainInfoResponse
import retrofit2.Response

interface MainInfoRepository {
    suspend fun getFoodsMenuInfo(): Response<MainInfoResponse>
}