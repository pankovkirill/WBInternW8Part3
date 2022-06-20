package com.example.wbinternw8part3.model

import com.example.wbinternw8part3.model.remote.dto.ImageResponse

sealed class AppState {
    data class SuccessMain(val imageResponse: List<ImageResponse>) : AppState()
    data class SuccessFavorite(val favoriteData: List<FavoriteData>) : AppState()
    data class Error(val e: Throwable) : AppState()
    object Loading : AppState()
}