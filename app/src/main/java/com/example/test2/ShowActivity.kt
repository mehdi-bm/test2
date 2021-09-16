package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import com.example.test2.databinding.ActivityShowBinding
import com.squareup.picasso.Picasso

class ShowActivity : AppCompatActivity() {
    lateinit var binding:ActivityShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        binding= ActivityShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val type=intent.getStringExtra("type")
           when(type){
               "recycler"->
               {
                   imgShow.setImageResource(intent.getIntExtra("imageID",R.drawable.phone1))
                   txtShowPrice.text=intent.getStringExtra("txtPrice")
               }
               "picasso"->
               {
                   val imgUrl=intent.getStringExtra("imageID2")
                  Picasso.with(this@ShowActivity).load(imgUrl).into(imgShow)
               }
           }



        }
    }
}