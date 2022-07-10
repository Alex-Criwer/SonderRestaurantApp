package com.example.sonder_restaurant.features.detailsScreen.data.repositories

import com.example.sonder_restaurant.features.detailsScreen.data.retrofit.entities.DetailInfoResponse
import retrofit2.Response

interface DetailInfoRepository {
    suspend fun getDetails(): Response<DetailInfoResponse>
}