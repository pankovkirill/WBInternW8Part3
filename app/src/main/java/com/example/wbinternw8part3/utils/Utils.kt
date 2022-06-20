package com.example.wbinternw8part3.utils

import com.example.wbinternw8part3.model.FavoriteData
import com.example.wbinternw8part3.model.remote.dto.ImageResponse
import com.example.wbinternw8part3.model.room.FavoriteEntity

fun mapImageResponseToFavoriteEntity(imageResponse: ImageResponse): FavoriteEntity {
    return FavoriteEntity(
        imageResponse.id,
        imageResponse.url,
    )
}

fun mapFavoriteEntityToFavoriteData(favoriteEntityList: List<FavoriteEntity>): List<FavoriteData> {
    return favoriteEntityList.map {
        FavoriteData(it.id, it.image)
    }
}