package com.example.test2.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.test2.R
import com.example.test2.databinding.ListviewTempBinding

class CustomAdapter(private val data:List<DataModel>):BaseAdapter() {
private lateinit var binding: ListviewTempBinding
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view=LayoutInflater.from(parent!!.context).inflate(R.layout.listview_temp,null)

        val data1=getItem(position)

        val id=parent.context.resources.getIdentifier(data1.img,"drawable",parent.context.packageName)



        binding.imgProgramming.setImageResource(id)

        binding.txtProgramming.text=data1.name

        return view
    }

    override fun getItem(position: Int): DataModel =data[position]
    override fun getItemId(position: Int): Long =position.toLong()

    override fun getCount(): Int =data.count()
}