package com.example.test2.utils

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.R
import com.example.test2.activites.ShowActivity

class RecyclerAdapter(private val data:List<DataModelRecycler>,private val context:Context)
    :RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CustomViewHolder {
       val view=LayoutInflater.from(parent.context)
           .inflate(R.layout.sample_row_recycler,parent,false)
        return CustomViewHolder(view)
    }


    override fun onBindViewHolder(parent: CustomViewHolder, position: Int) {
        parent.img.setImageResource(data[position].image)
        parent.txt.text=data[position].price

        parent.img.setOnClickListener {
            Toast.makeText(context, "position= $position price= ${data[position].price}", Toast.LENGTH_SHORT).show()
        }

        parent.cardView.setOnClickListener {
            val intent= Intent(context, ShowActivity::class.java)
            intent.putExtra("imageID",data[position].image)
            intent.putExtra("txtPrice",data[position].price)
            intent.putExtra("type","recycler1")
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int =data.count()

    inner class CustomViewHolder(val itemView:View):RecyclerView.ViewHolder(itemView){
        val txt=itemView.findViewById<TextView>(R.id.txt_row_recycler)
        val img=itemView.findViewById<ImageView>(R.id.img_row_recycler)
        val cardView=itemView.findViewById<CardView>(R.id.cardView_recycler)
    }
}