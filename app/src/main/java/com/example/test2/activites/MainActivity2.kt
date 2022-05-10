package com.example.test2.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.test2.R
import com.example.test2.databinding.ActivityMain2Binding
import com.example.test2.ui.Home.HomeFragment
import com.example.test2.ui.Person.PersonFragment

class MainActivity2 : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val homeFragment=HomeFragment()
        val personFragment=PersonFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,homeFragment)
            commit()
        }

        toggle=ActionBarDrawerToggle(this,binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flFragment,homeFragment)
                        commit()
                    }
                }
                R.id.nav_person -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flFragment,personFragment)
                        commit()
                    }
                }
                R.id.nav_message -> Toast.makeText(applicationContext , "Message", Toast.LENGTH_SHORT).show()
                R.id.nav_basket -> Toast.makeText(applicationContext , "Basket", Toast.LENGTH_SHORT).show()
                R.id.nav_setting -> Toast.makeText(applicationContext , "Setting", Toast.LENGTH_SHORT).show()
                R.id.nav_phone -> Toast.makeText(applicationContext , "Phone", Toast.LENGTH_SHORT).show()
            }
            true

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}