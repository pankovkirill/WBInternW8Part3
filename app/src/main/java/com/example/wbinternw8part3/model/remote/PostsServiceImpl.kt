package com.example.wbinternw8part3.model.remote

import com.example.wbinternw8part3.model.remote.dto.ImageResponse
import com.example.wbinternw8part3.model.remote.dto.MessageResponse
import com.example.wbinternw8part3.model.remote.dto.VoteRequest
import com.example.wbinternw8part3.model.remote.dto.VoteResponse
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlin.text.get

class PostsServiceImpl(
    private val client: HttpClient
) : PostsService {
    override suspend fun getRandomImage(): List<ImageResponse> {
        return client.get {
            url(HttpRoutes.PICTURE_URL)
        }
    }

    override suspend fun createVote(postRequest: VoteRequest): MessageResponse {
        return client.post {
            url(HttpRoutes.VOTES_URL)
            contentType(ContentType.Application.Json)
            body = postRequest
        }
    }
}