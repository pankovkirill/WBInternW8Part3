package com.example.wbinternw8part3.model.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class MessageResponse(
    val message: String
)