package com.example.wbinternw8part3.model.remote

object HttpRoutes {
    private const val API_KEY = "b9940f18-3124-4b46-bb7d-2f03a64e11e2"
    private const val BASE_URL = "https://api.thecatapi.com"

    const val PICTURE_URL = "$BASE_URL/v1/images/search?api_key=$API_KEY"

    const val VOTES_URL = "$BASE_URL/v1/votes?api_key=$API_KEY"
}