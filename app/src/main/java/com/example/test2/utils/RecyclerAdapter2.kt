package com.example.test2.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.R



class RecyclerAdapter2(private val data:List<DataModelRecycler2>,private val context: Context)
    :RecyclerView.Adapter<RecyclerAdapter2.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CustomViewHolder {
     val view=LayoutInflater.from(parent.context)
         .inflate(R.layout.sample_row_recycler2,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(parent: CustomViewHolder, position: Int) {
        parent.img1.setImageResource(data[position].image)
        parent.txtTitle.text=data[position].title
        parent.txtBrand.text=data[position].brand
        parent.txtPrice.text=data[position].price

        parent.cardview.setOnClickListener {

        }

        parent.btnBuy.setOnClickListener {
            val number= parent.etNumber.text
            if (number.isNotEmpty()){
                Toast.makeText(context, "Added To Card Buy", Toast.LENGTH_SHORT).show()
            }else
                Toast.makeText(context, "Can not Number Empty", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int =data.count()

    inner class CustomViewHolder(val itemView:View):RecyclerView.ViewHolder(itemView){
         val img1=itemView.findViewById<ImageView>(R.id.img_row_recycler2)
         val txtTitle=itemView.findViewById<TextView>(R.id.txt_row_recycler2_title)
         val txtBrand=itemView.findViewById<TextView>(R.id.txt_row_recycler2_brand)
         val txtPrice=itemView.findViewById<TextView>(R.id.txt_row_recycler2_price)
         val btnBuy=itemView.findViewById<Button>(R.id.btn_row_recycler2_buy)
         val etNumber=itemView.findViewById<TextView>(R.id.et_row_recycler2_number)
         val cardview=itemView.findViewById<CardView>(R.id.cardView_recycler2)

    }


}