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
            txtShowPrice.text=intent.getStringExtra("txtPrice")
            if(txtShowPrice.text.isEmpty())
            {
                val test1=intent.getStringExtra("imageID")
                Picasso.with(this@ShowActivity).load(test1).into(imgShow)
            }else{
                val test1=intent.getIntExtra("imageID",R.drawable.phone1)
                imgShow.setImageResource(test1)
            }


        }
    }
}