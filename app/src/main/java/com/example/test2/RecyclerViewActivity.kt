package com.example.test2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test2.databinding.ActivityRecyclerViewBinding
import com.example.test2.utils.DataModelRecycler
import com.example.test2.utils.RecyclerAdapter

class RecyclerViewActivity : AppCompatActivity() {
    val data= listOf(
        DataModelRecycler(R.drawable.phone1,"1,000,000T"),
        DataModelRecycler(R.drawable.phone2,"1,500,000T"),
        DataModelRecycler(R.drawable.phone3,"1,060,000T"),
        DataModelRecycler(R.drawable.phone4,"1,800,000T"),
        DataModelRecycler(R.drawable.phone5,"2,000,000T"),
        DataModelRecycler(R.drawable.phone6,"1,750,000T"),
        DataModelRecycler(R.drawable.phone1,"3,000,000T"),
        DataModelRecycler(R.drawable.phone2,"3,800,000T"),
        DataModelRecycler(R.drawable.phone3,"5,000,000T"),
        DataModelRecycler(R.drawable.phone4,"6,000,000T"),
        DataModelRecycler(R.drawable.phone5,"4,000,000T"),
        DataModelRecycler(R.drawable.phone6,"4,900,000T"),
        DataModelRecycler(R.drawable.phone1,"8,000,000T"),
        DataModelRecycler(R.drawable.phone2,"2,700,000T"),
        DataModelRecycler(R.drawable.phone3,"3,500,000T"),
        DataModelRecycler(R.drawable.phone4,"6,400,000T"),
        DataModelRecycler(R.drawable.phone5,"2,300,000T"),
        DataModelRecycler(R.drawable.phone6,"1,200,000T")
    )

    lateinit var binding:ActivityRecyclerViewBinding
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recyclerView.layoutManager=LinearLayoutManager(this,HORIZONTAL,true)
        binding.recyclerView.adapter=RecyclerAdapter(data,this)


    }
}