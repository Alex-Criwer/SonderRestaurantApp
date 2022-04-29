package com.example.sonder_restaurant.features.mainScreen.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sonder_restaurant.features.mainScreen.data.repositories.MainInfoRepositoryImpl
import com.example.sonder_restaurant.features.mainScreen.data.retrofit.MainApiService

class MainViewMadelFactory: ViewModelProvider.Factory {
    private val mainInfoRepositoryImpl = MainInfoRepositoryImpl(MainApiService.create())

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(mainInfoRepositoryImpl = mainInfoRepositoryImpl) as T
    }
}