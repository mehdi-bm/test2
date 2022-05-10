package com.example.test2.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.test2.R
import com.example.test2.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {

    private val start=12000L
    private var timer=start
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain3Binding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        setTitle("Timer 2")
        binding.apply {
            btnMain3Pause.isEnabled=false
            btnMain3Reset.isEnabled=false
        }
        setPriceOf()
        updateText()
    }

    private fun setPriceOf() {
        val price="120000T"
        val spannable=SpannableString(price)
        spannable.setSpan(StrikethroughSpan(),0,price.length, Spanned.SPAN_MARK_MARK)
        binding.txtMain3Price.text=spannable
        binding.txtMain3PriceOf.text="60000T"
    }

    fun onClick(view:View){
        when(view.id){
            R.id.btn_main3_start -> {
                startCountDown()
                Toast.makeText(this@MainActivity3,"Start",Toast.LENGTH_LONG).show()
            }
            R.id.btn_main3_pause -> pauseCountDown()
            R.id.btn_main3_reset -> resetCountDown()
        }
    }

    private fun startCountDown() {
        binding.apply {
            btnMain3Pause.isEnabled=true
            btnMain3Reset.isEnabled=false
        }
        countDownTimer = object : CountDownTimer(timer,1000){
            override fun onTick(p0: Long) {
                timer=p0
                updateText()

            }

            override fun onFinish() {
                binding.apply {
                    txtMain3PriceOf.visibility=View.GONE
                    txtMain3Timer.visibility=View.GONE
                    txtMain3Price.text="120000T"
                }
            }

        }.start()
        binding.apply {
            btnMain3Start.isEnabled=false

        }
    }

    private fun pauseCountDown() {
        binding.apply {
            btnMain3Start.isEnabled=true
            btnMain3Reset.isEnabled=true
            btnMain3Pause.isEnabled=false
        }
        countDownTimer.cancel()
        Toast.makeText(this@MainActivity3,"Pause",Toast.LENGTH_LONG).show()
    }

    private fun resetCountDown() {
        binding.apply {
            btnMain3Start.isEnabled=true
            btnMain3Pause.isEnabled=false
            btnMain3Reset.isEnabled=false
        }
        timer=start
        updateText()
        Toast.makeText(this@MainActivity3,"Reset",Toast.LENGTH_LONG).show()
    }

    private fun updateText(){
        val min= (timer / 1000) / 60
        val second= (timer / 1000) % 60
        val txtTimer= findViewById<TextView>(R.id.txt_main3_timer)
        val timeFormat= String.format("%02d:%02d",min,second)

        txtTimer.text=timeFormat
    }


}