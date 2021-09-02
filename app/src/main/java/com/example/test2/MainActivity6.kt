package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        val text=intent.getStringExtra("name")
        val img=intent.getStringExtra("image")

        val id=this.resources.getIdentifier(img,"drawable",this.packageName)

        title = text

        val image=findViewById<ImageView>(R.id.img_main6)

        image.setImageResource(id)
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
    }
}