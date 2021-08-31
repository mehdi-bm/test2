package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test2.databinding.ActivityMain4Binding
import com.example.test2.databinding.ActivityMain5Binding
import com.example.test2.utils.DataModel


class MainActivity5 : AppCompatActivity() {
    lateinit var binding: ActivityMain5Binding
    val listData= listOf(
        DataModel("Kotlin","kotlin"),
        DataModel("Java","java"),
        DataModel("C#","c_sharp"),
        DataModel("JavaScript","javascript"),
        DataModel("VB","vb"),
        DataModel("Python","python"),
        DataModel("php","php")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain5Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        setTitle("test 5")
    }
}