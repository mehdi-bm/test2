package com.example.test2.utils
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.R
import com.example.test2.activites.ShowActivity
import com.squareup.picasso.Picasso

class PicassoAdapter(private val data:List<String>,private val context: Context)
    :RecyclerView.Adapter<PicassoAdapter.PicassoViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, position: Int): PicassoViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.sample_row_picasso,parent,false)
        return PicassoViewHolder(view)
    }

    override fun onBindViewHolder(parent: PicassoViewHolder, position: Int) {
        Picasso.with(context).load(data[position]).into(parent.img)
        parent.img.setOnClickListener {
            val intent= Intent(context, ShowActivity::class.java)
            intent.putExtra("imageID2",data[position])
            intent.putExtra("type","picasso")
            context.startActivity(intent)
      }
    }

    override fun getItemCount(): Int =data.count()

    inner class PicassoViewHolder(val itemView: View):RecyclerView.ViewHolder(itemView){
        val img=itemView.findViewById<ImageView>(R.id.img_row_picasso)
    }
}