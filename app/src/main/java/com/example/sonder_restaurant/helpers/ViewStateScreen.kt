package com.example.sonder_restaurant.helpers

data class ViewStateScreen (
    val isDownloaded: Boolean = false,
    val error: Throwable? = null
)