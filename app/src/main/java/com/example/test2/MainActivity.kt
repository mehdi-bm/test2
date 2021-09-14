package com.example.test2



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.test2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val listData = listOf(
        "Timer 1",
        "Timer 2",
        "Test 4",
        "List Programming Language",
        "VideoView",
        "MediaPlayer",
        "TimePicker",
        "DatePicker",
        "NavigationDrawer",
        "RecyclerView",
        "Picasso"
    )
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root.apply { setContentView(this) }
        title = "Main"

        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_activated_1,listData)

        binding.listMain.adapter=adapter

        binding.listMain.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,"${listData[i]} ${i.toString()}",Toast.LENGTH_SHORT).show()
            when(i){
                0->{
                    val i=Intent(this,Timer1Activity::class.java)
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
                4->{
                    val i=Intent(this,VideoViewActivity::class.java)
                    startActivity(i)
                }
                5->{
                    val i=Intent(this,MediaPlayerActivity::class.java)
                    startActivity(i)
                } 6->{
                    val i=Intent(this,TimePickerActivity::class.java)
                    startActivity(i)
                }7->{
                    val i=Intent(this,DatePickerActivity::class.java)
                    startActivity(i)
                }8->{
                    val i=Intent(this,MainActivity2::class.java)
                    startActivity(i)
                }9->{
                    val i=Intent(this,RecyclerViewActivity::class.java)
                    startActivity(i)
                }10->{
                    val i=Intent(this,PicassoActivity::class.java)
                    startActivity(i)
                }

            }
        }

        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_settings-> Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show()
            R.id.menu_account-> Toast.makeText(this, "account", Toast.LENGTH_SHORT).show()
            R.id.menu_dashboard-> Toast.makeText(this, "dashboard", Toast.LENGTH_SHORT).show()
            R.id.menu_alarm-> Toast.makeText(this, "alarm", Toast.LENGTH_SHORT).show()


        }
        return true
    }

}







