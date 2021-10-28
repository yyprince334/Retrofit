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
    val myResponse2: MutableLiveData<retrofit2.Response<Post>> = MutableLiveData()
    val myResponse3: MutableLiveData<retrofit2.Response<List<Post>>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }
    fun getPost2(number: Int) {
        viewModelScope.launch {
            val response = repository.getPost2(number)
            myResponse2.value = response
        }
    }
    fun getCustomPost(userId: Int) {
        viewModelScope.launch {
            val response = repository.getCustomPost(userId)
            myResponse3.value = response
        }
    }

}