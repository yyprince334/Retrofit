package com.prince.retrofit.repository

import com.prince.retrofit.api.RetrofitInstance
import com.prince.retrofit.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPost(userId: Int): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost(userId)
    }
}