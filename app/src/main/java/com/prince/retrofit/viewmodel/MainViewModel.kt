package com.prince.retrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prince.retrofit.model.Post
import com.prince.retrofit.repository.Repository
import kotlinx.coroutines.launch
import okhttp3.Response
import retrofit2.http.POST

class MainViewModel(private val repository: Repository): ViewModel() {
    val myResponse: MutableLiveData<retrofit2.Response<Post>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }
}