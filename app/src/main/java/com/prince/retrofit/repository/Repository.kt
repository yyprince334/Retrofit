package com.prince.retrofit.repository

import com.prince.retrofit.api.RetrofitInstance
import com.prince.retrofit.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}