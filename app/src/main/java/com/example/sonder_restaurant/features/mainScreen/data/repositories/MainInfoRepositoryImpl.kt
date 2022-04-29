package com.example.sonder_restaurant.features.mainScreen.data.repositories

import com.example.sonder_restaurant.features.mainScreen.data.repositories.interfaces.MainInfoRepository
import com.example.sonder_restaurant.features.mainScreen.data.retrofit.MainApiService
import com.example.sonder_restaurant.features.mainScreen.data.retrofit.entities.MainInfoResponse
import retrofit2.Response

class MainInfoRepositoryImpl(private val mainApiService: MainApiService): MainInfoRepository {
    override suspend fun getFoodsMenuInfo(): Response<MainInfoResponse> {
        return mainApiService.getFoods()
    }
}