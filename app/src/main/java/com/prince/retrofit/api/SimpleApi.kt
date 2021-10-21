package com.prince.retrofit.api

import com.prince.retrofit.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("post/1")
    suspend fun getPost(): Response<Post>
}