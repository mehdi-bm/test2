package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.ToggleButton
import com.example.test2.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private var pauseOffset=0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        setTitle("Timer 1")


        // check timer
        binding.apply {
            tgbtnMain2.setOnClickListener {
                if (tgbtnMain2.isChecked){
                    chrMain2.base=SystemClock.elapsedRealtime() - pauseOffset
                    chrMain2.start()
                }
                else {
                    pauseOffset=SystemClock.elapsedRealtime()-chrMain2.base
                    chrMain2.stop()
                }
                binding.btnMain2Reset.setOnClickListener {
                    chrMain2.base=SystemClock.elapsedRealtime()
                    pauseOffset=0L
                }
            }



        }



    }

//    fun checkTimer(){
//
//    }
}