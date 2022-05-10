package com.example.test2.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test2.databinding.ActivityTimePickerBinding

class TimePickerActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTimePickerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTimePickerBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.apply {
            timepicker.setIs24HourView(true)

            timepicker.setOnTimeChangedListener { _, h, m ->
                txtTimepicker.text="$h : $m"
            }

        }
    }
}