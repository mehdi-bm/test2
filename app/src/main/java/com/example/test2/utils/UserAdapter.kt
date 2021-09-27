package com.example.test2.utils

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.EditUserActivity
import com.example.test2.R
import com.example.test2.realmModel.ObjectUser
import com.example.test2.realmModel.UserDAO

class UserAdapter(private val data:List<ObjectUser>,private val context: Context):RecyclerView.Adapter<UserAdapter.viewHolder>() {

    inner class viewHolder(val itemView: View):RecyclerView.ViewHolder(itemView){
        val txtId=itemView.findViewById<TextView>(R.id.tv_show_users_id)
        val txtName=itemView.findViewById<TextView>(R.id.tv_show_users_name)
        val txtFamiliy=itemView.findViewById<TextView>(R.id.tv_show_users_family)

        val imgEdit=itemView.findViewById<ImageView>(R.id.img_show_users_edit)
        val imgDelete=itemView.findViewById<ImageView>(R.id.img_show_users_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): viewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_show_users,parent,false)

        return viewHolder(view)
    }

    override fun onBindViewHolder(parent: viewHolder, position: Int) {
        parent.txtId.text=data[position].id.toString()
        parent.txtName.text=data[position].name
        parent.txtFamiliy.text=data[position].family.toString()
        var userDAO=UserDAO()


        parent.imgEdit.setOnClickListener {
            //get data
            val id=data[position].id
            if(id!=0) {
                val intent = Intent(context, EditUserActivity::class.java)
                intent.putExtra("id", id)
                context.startActivity(intent)
            }



        }

        parent.imgDelete.setOnClickListener {

        }
    }

    override fun getItemCount(): Int =data.count()
}