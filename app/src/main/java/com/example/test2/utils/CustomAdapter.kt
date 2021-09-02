package com.example.test2.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.test2.R
import com.example.test2.databinding.ListviewTempBinding
import de.hdodenhof.circleimageview.CircleImageView

class CustomAdapter(private val data:List<DataModel>):BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

      //  val view=LayoutInflater.from(parent!!.context).inflate(R.layout.listview_temp,null)
        val view:View
        val holder:CustomViewHolder

        if (convertView==null){
            view=LayoutInflater.from(parent.context).inflate(R.layout.listview_temp,null)
            holder= CustomViewHolder()
            holder.img=view.findViewById<CircleImageView>(R.id.img_programming)
            holder.txt=view.findViewById<TextView>(R.id.txt_programming)
            view.tag=holder
        }else{
            holder=convertView.tag as CustomViewHolder
            view=convertView

        }


        val data1=getItem(position)

        val id=parent.context.resources.getIdentifier(data1.img,"drawable",parent.context.packageName)
        val img= view.findViewById<CircleImageView>(R.id.img_programming)

        img.setImageResource(id)
        view.findViewById<TextView>(R.id.txt_programming).text=data1.name

       img.setOnClickListener {
           Toast.makeText(parent.context,"${data1.name} ", Toast.LENGTH_SHORT).show()
       }



        return view
    }

    override fun getItem(position: Int): DataModel =data[position]
    override fun getItemId(position: Int): Long =position.toLong()

    override fun getCount(): Int =data.count()

    class CustomViewHolder{
        lateinit var img:CircleImageView
        lateinit var txt:TextView

    }
}