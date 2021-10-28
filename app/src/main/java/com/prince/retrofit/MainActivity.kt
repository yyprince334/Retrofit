package com.prince.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
         val button = findViewById<Button>(R.id.button)
         val number_editText = findViewById<TextView>(R.id.number_editText)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

         button.setOnClickListener {
             val myNumber = number_editText.text.toString()
             viewModel.getCustomPost(Integer.parseInt(myNumber))
             viewModel.myResponse3.observe(this, Observer {response ->
                 if (response.isSuccessful) {
                     textView.text = response.body()?.toString()
                 }else {
                     textView.text = response.code().toString()
                 }
             })
         }
    }
}