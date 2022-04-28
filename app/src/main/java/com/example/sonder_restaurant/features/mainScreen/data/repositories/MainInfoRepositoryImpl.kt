package com.example.sonder_restaurant.features.mainScreen.data.repositories

import com.example.sonder_restaurant.features.mainScreen.data.repositories.interfaces.MainInfoRepository
import com.example.sonder_restaurant.features.mainScreen.data.retrofit.MainApiService
import com.example.sonder_restaurant.features.mainScreen.data.retrofit.entities.MainInfoResponse
import retrofit2.Response

class MainInfoRepositoryImpl(val mainApiService: MainApiService): MainInfoRepository {
    override suspend fun getMainInfo(): Response<MainInfoResponse> {
        return mainApiService.getFoods()
    }
}