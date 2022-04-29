package com.example.sonder_restaurant.features.mainScreen.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sonder_restaurant.features.mainScreen.data.repositories.interfaces.MainInfoRepository
import com.example.sonder_restaurant.features.mainScreen.data.retrofit.entities.MainInfoResponse
import com.example.sonder_restaurant.features.mainScreen.data.retrofit.entities.MenuItem
import com.example.sonder_restaurant.helpers.ViewStateScreen
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import timber.log.Timber

class MainViewModel(private val mainInfoRepositoryImpl: MainInfoRepository): ViewModel() {

    // init CoroutineExceptionHandler
    private val errorHandler = CoroutineExceptionHandler { coroutineContext, error ->
        Timber.d("timber error in mainViewModel is ${error.message}")
    }

    //init LiveData
//    private val _viewState = MutableLiveData<ViewStateScreen>()
//    val viewState: LiveData<ViewStateScreen> = _viewState
    private val _foodsMenu = MutableLiveData<List<MenuItem>>()
    val foodsMenu: LiveData<List<MenuItem>> = _foodsMenu

    fun getFoodsInfo() {
        viewModelScope.launch(errorHandler) {
            withContext(Dispatchers.IO) {
                val foodsInfoResponse = mainInfoRepositoryImpl.getFoodsMenuInfo()
                if (foodsInfoResponse.isSuccessful) {
                    Timber.d("timber is success")
                    val foodsList: List<MenuItem> = foodsInfoResponse.body()?.foods ?: emptyList()
                    Timber.d("timber ${foodsList[0]}")
                    _foodsMenu.postValue(foodsList)
//                    _viewState.postValue(ViewStateScreen(isDownloaded = true))
                } else {
                    Timber.d("timber is not successful ${foodsInfoResponse.code()}")
                }
            }
        }
    }
}