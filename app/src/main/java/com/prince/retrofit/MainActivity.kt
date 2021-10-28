package com.prince.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.prince.retrofit.repository.Repository
import com.prince.retrofit.viewmodel.MainViewModel
import com.prince.retrofit.viewmodel.MainViewModelFactory


 private lateinit var viewModel: MainViewModel
 class MainActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val textView = findViewById<TextView>(R.id.textView)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer {response ->
            if (response.isSuccessful) {
                Log.d("Response", response.body()?.userId.toString())
                Log.d("Response", response.body()?.id.toString())
                textView.text = response.body()?.title!!
                Log.d("Response", response.body()?.body!!)
            }else {
                Log.d("Response", response.errorBody().toString())
                textView.text = response.code().toString()
            }
        })
    }
}