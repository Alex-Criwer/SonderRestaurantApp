package com.example.sonder_restaurant.features.detailsScreen.data.repositories

import com.example.sonder_restaurant.features.detailsScreen.data.retrofit.DetailApiService
import com.example.sonder_restaurant.features.detailsScreen.data.retrofit.entities.DetailInfoResponse
import retrofit2.Response

class DetailInfoRepositoryImpl(val detailApiService: DetailApiService): DetailInfoRepository {
    override suspend fun getDetails(): Response<DetailInfoResponse> {
        return detailApiService.getDetails()
    }
}