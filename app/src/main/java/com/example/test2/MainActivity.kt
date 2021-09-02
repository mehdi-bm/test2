package com.example.test2



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.test2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val listData = listOf(
        "Timer 1",
        "Timer 2",
        "Test 4",
        "List Programming Language"
    )
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        setTitle("Main")

        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_activated_1,listData)

        binding.listMain.adapter=adapter

        binding.listMain.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,"${listData[i]} ${i.toString()}",Toast.LENGTH_SHORT).show()
            when(i){
                0->{
                    val i=Intent(this,MainActivity2::class.java)
                    startActivity(i)
                }
                1->{
                    val i=Intent(this,MainActivity3::class.java)
                    startActivity(i)
                }
                2->{
                    val i=Intent(this,MainActivity4::class.java)
                    startActivity(i)
                }  3->{
                    val i=Intent(this,MainActivity5::class.java)
                    startActivity(i)
                }

            }
        }

        }

}







