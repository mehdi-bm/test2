package com.example.test2.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test2.databinding.ActivityDatePickerBinding

class DatePickerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDatePickerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDatePickerBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.apply {
            btnDatepickerShow.setOnClickListener {
                txtDatepicker.text="${datepicker.year}/" +
                                    "${datepicker.month}/" +
                                    "${datepicker.dayOfMonth}"
            }
        }

    }
}