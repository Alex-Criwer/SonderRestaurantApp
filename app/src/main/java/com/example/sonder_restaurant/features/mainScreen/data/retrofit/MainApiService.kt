package com.example.sonder_restaurant.features.mainScreen.data.retrofit

import com.example.sonder_restaurant.features.mainScreen.data.retrofit.entities.MainInfoResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MainApiService {

    @GET("/get_foods")
    suspend fun getFoods(): Response<MainInfoResponse>

    companion object {
        private const val BASE_URL = "https://hidden-sun-2260.getsandbox.com"

        fun create(): MainApiService {
            return Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MainApiService::class.java)
        }
    }
}