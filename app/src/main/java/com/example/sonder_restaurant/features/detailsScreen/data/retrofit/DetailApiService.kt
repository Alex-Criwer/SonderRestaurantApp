package com.example.sonder_restaurant.features.detailsScreen.data.retrofit

import com.example.sonder_restaurant.features.detailsScreen.data.retrofit.entities.DetailInfoResponse
import com.example.sonder_restaurant.features.mainScreen.data.retrofit.MainApiService
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DetailApiService {

    @GET("/get_details")
    suspend fun getDetails(): Response<DetailInfoResponse>

    companion object {
        private const val BASE_URL = "https://hidden-sun-2260.getsandbox.com"

        fun create(): DetailApiService {
            return Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DetailApiService::class.java)
        }
    }
}