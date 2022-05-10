package com.example.test2.activites

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.test2.databinding.ActivityPicassoBinding

import com.example.test2.utils.PicassoAdapter

class PicassoActivity : AppCompatActivity() {
    private val data= listOf(
        "http://www.coca.ir/wp-content/uploads/2017/02/nature-photos-2.jpg",
        "http://www.coca.ir/wp-content/uploads/2017/02/nature-photos-3.jpg",
        "http://www.coca.ir/wp-content/uploads/2014/02/beautiful-winter-photos-1.jpg",
        "http://www.coca.ir/wp-content/uploads/2013/05/tuscany-italy-photos-1.jpg",
        "http://www.coca.ir/wp-content/uploads/2017/02/nature-photos-2.jpg",
        "http://www.coca.ir/wp-content/uploads/2017/02/nature-photos-3.jpg",
        "http://www.coca.ir/wp-content/uploads/2014/02/beautiful-winter-photos-1.jpg",
        "http://www.coca.ir/wp-content/uploads/2013/05/tuscany-italy-photos-1.jpg",
        "http://www.coca.ir/wp-content/uploads/2017/02/nature-photos-2.jpg",
        "http://www.coca.ir/wp-content/uploads/2017/02/nature-photos-3.jpg",
        "http://www.coca.ir/wp-content/uploads/2014/02/beautiful-winter-photos-1.jpg",
        "http://www.coca.ir/wp-content/uploads/2013/05/tuscany-italy-photos-1.jpg",
        "http://www.coca.ir/wp-content/uploads/2017/02/nature-photos-2.jpg"


    )
    lateinit var binding: ActivityPicassoBinding
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPicassoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager=
            GridLayoutManager(this,2,LinearLayout.VERTICAL,true)

        binding.recyclerView.adapter=PicassoAdapter(data,this)

    }
}