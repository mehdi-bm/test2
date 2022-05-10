package com.example.test2.activites

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.test2.R
import com.example.test2.databinding.ActivityMain6Binding
import com.google.android.material.snackbar.Snackbar

class MainActivity6 : AppCompatActivity() {
    lateinit var binding:ActivityMain6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain6Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        val text=intent.getStringExtra("name")
        val img=intent.getStringExtra("image")

        val id=this.resources.getIdentifier(img,"drawable",this.packageName)

        title = text

        val image=findViewById<ImageView>(R.id.img_main6)
        val btnsend=findViewById<Button>(R.id.btn_main6_send)
        val txtTitle=findViewById<TextView>(R.id.txt_main6_title)
        txtTitle.text=text
        image.setImageResource(id)
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()

        btnsend.setOnClickListener {
            val snackbar = Snackbar.make(view, "Test SnackBar", Snackbar.LENGTH_INDEFINITE)
                .setAction("Alert") {

//                    AlertDialog.Builder(this)
//                        .setTitle("this is title alert")
//                        .setIcon(id)
//                        .setMessage("hi this is test message alert $text")
//                        .setPositiveButton("Yes",DialogInterface.OnClickListener { _, _ ->
//                            Toast.makeText(this,"Yes",Toast.LENGTH_SHORT).show()
//                        })
//                        .setNegativeButton("No",DialogInterface.OnClickListener { _, _ ->
//                            Toast.makeText(this,"No",Toast.LENGTH_SHORT).show()
//                        })
//                        .setCancelable(true)
//
//                        .setOnCancelListener {
//                            Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show()
//                        }
//
//                        .create()
//                        .show()


                    AlertDialog.Builder(this)
                        .setTitle("SetColor")
                        .setItems(R.array.colors,DialogInterface.OnClickListener { _, position ->
                            when(position){
                                0->txtTitle.setTextColor( Color.RED)
                                1->txtTitle.setTextColor( Color.BLUE)
                                2->txtTitle.setTextColor(Color.GREEN)
                            }
                        }).create()
                        .show()



                }
                .setActionTextColor(ContextCompat.getColor(this, R.color.purple_200))
            snackbar.setBackgroundTint(ContextCompat.getColor(this, R.color.purple_600))


            snackbar.show()

        }

    }


}