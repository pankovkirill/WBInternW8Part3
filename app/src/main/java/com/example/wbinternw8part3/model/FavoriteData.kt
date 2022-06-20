package com.example.wbinternw8part3.model

import kotlinx.serialization.Serializable

@Serializable
data class FavoriteData(
    val id: String,
    val url: String
)