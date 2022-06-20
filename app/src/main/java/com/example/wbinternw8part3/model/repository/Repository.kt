package com.example.wbinternw8part3.model.repository

import com.example.wbinternw8part3.model.FavoriteData
import com.example.wbinternw8part3.model.remote.dto.ImageResponse

interface Repository {
    suspend fun getDataFromDB(): List<FavoriteData>

    suspend fun insertDataToDB(imageResponse: ImageResponse)
}