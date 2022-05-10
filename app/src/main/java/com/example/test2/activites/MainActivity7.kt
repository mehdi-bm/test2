package com.example.test2.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.test2.R
import com.example.test2.databinding.ActivityMain7Binding
import com.example.test2.ui.TestFragment.FirstFragment


class MainActivity7 : AppCompatActivity() {
    private lateinit var binding: ActivityMain7Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtTest.setSingleLine()
        binding.txtTest.isSelected=true
        binding.txtTest.text="Test Application Sample Test Application Sample Test Application Sample"

        binding.btnFragmentShow.setOnClickListener {
          val firstFragment=FirstFragment()
           replaceFragment(firstFragment)
        }
    }

    private fun replaceFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayoutTest, fragment)
            commit()
        }
    }

}