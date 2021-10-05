package com.example.test2.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.test2.R
import com.example.test2.databinding.ListviewTempBinding
import de.hdodenhof.circleimageview.CircleImageView

class DataAdapter(private val list:List<Users>):BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

      //  val view=LayoutInflater.from(parent!!.context).inflate(R.layout.listview_temp,null)
        val view:View
        val holder:CustomViewHolder

        if (convertView==null){
            view=LayoutInflater.from(parent.context).inflate(R.layout.temp_item_list,null)
            holder= CustomViewHolder()
            holder.txtName=view.findViewById<TextView>(R.id.txtName)
            holder.txtFamily=view.findViewById<TextView>(R.id.txtFamily)
            holder.txtAge=view.findViewById<TextView>(R.id.txtAge)
            view.tag=holder
        }else{
            holder=convertView.tag as CustomViewHolder
            view=convertView

        }


        val data=getItem(position)
        holder.txtName.text=data.name
        holder.txtFamily.text=data.family
        holder.txtAge.text=data.age





        return view
    }

    override fun getItem(position: Int): Users =list[position]
    override fun getItemId(position: Int): Long =0

    override fun getCount(): Int =list.count()

    class CustomViewHolder{
        lateinit var txtName:TextView
        lateinit var txtFamily:TextView
        lateinit var txtAge:TextView

    }
}