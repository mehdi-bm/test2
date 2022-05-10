package com.example.test2.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.test2.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    lateinit var binding: ActivityMain4Binding
    val Arraystr= arrayListOf<String>(
        "bad",
        "normal",
        "good",
        "very good"
    )
    val Arraystr2= arrayListOf<String>(
        "ali",
        "alireza",
        "mehdi",
        "masoud",
        "amir",
        "ahmad",
        "mohammad",
        "maryam"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain4Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        setTitle("test 4")

        val ad=ArrayAdapter(this,android.R.layout.simple_list_item_1,Arraystr2)
        binding.apply {
            ratingBar.setOnRatingBarChangeListener { ratingBar, fl, b ->
                if (ratingBar.rating in 0.0..2.0)
                    Toast.makeText(this@MainActivity4, Arraystr[0], Toast.LENGTH_SHORT).show()
                else  if (ratingBar.rating in 2.5..3.0)
                    Toast.makeText(this@MainActivity4, Arraystr[1], Toast.LENGTH_SHORT).show()
                else  if (ratingBar.rating in 3.5..4.0)
                    Toast.makeText(this@MainActivity4, Arraystr[2], Toast.LENGTH_SHORT).show()
                else  if (ratingBar.rating in 4.5..5.0)
                    Toast.makeText(this@MainActivity4, Arraystr[3], Toast.LENGTH_SHORT).show()
            }

            actxtMain4Test.setAdapter(ad)
            actxtMain4Test.threshold=1
        }
    }
}