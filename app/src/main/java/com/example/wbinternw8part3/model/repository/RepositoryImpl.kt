package com.example.wbinternw8part3.model.repository

import com.example.wbinternw8part3.model.FavoriteData
import com.example.wbinternw8part3.model.remote.dto.ImageResponse
import com.example.wbinternw8part3.model.room.FavoriteDataBaseFactory
import com.example.wbinternw8part3.utils.mapFavoriteEntityToFavoriteData
import com.example.wbinternw8part3.utils.mapImageResponseToFavoriteEntity

class RepositoryImpl : Repository {

    private val db = FavoriteDataBaseFactory.create().favoriteDao()

    override suspend fun getDataFromDB(): List<FavoriteData> {
        return mapFavoriteEntityToFavoriteData(db.getFavoriteList())
    }

    override suspend fun insertDataToDB(imageResponse: ImageResponse) {
        db.insert(mapImageResponseToFavoriteEntity(imageResponse))
    }
}