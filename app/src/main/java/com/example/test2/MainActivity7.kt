package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test2.databinding.ActivityMain7Binding

class MainActivity7 : AppCompatActivity() {
    lateinit var binding: ActivityMain7Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain7Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.webview.loadUrl("https://www.parsikhesab.ir")
    }
}