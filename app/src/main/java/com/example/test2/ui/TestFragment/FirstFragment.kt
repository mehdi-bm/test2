package com.example.test2.ui.TestFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.test2.R
import com.example.test2.databinding.FragmentFirstBinding

class FirstFragment:Fragment() {
    private lateinit var binding:FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFirstBinding.inflate(inflater,container,false)

        binding.imgFragmentFirst.setImageResource(R.drawable.phone1)
        binding.imgFragmentFirst.setOnClickListener {
            Toast.makeText(activity, "test", Toast.LENGTH_SHORT).show()
        }
        return binding.root


    }




}