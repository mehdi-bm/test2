package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.example.test2.databinding.ActivityTimer1Binding


class Timer1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTimer1Binding
    private var pauseOffset=0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTimer1Binding.inflate(layoutInflater)
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