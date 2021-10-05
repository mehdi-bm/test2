package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test2.databinding.ActivityMain10Binding
import com.example.test2.utils.DataAdapter
import com.example.test2.utils.RetrofitService
import com.example.test2.utils.Users

class MainActivity10 : AppCompatActivity(),RetrofitService.OnUsersJsonReceived {
    lateinit var binding:ActivityMain10Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain10Binding.inflate(layoutInflater)
        setContentView(binding.root)

        RetrofitService().getUsers(this)
    }

    override fun onRecieved(userInfo: List<Users>) {
        val myAdapter=DataAdapter(userInfo)
        binding.listView.adapter=myAdapter
    }
}