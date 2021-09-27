package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.test2.databinding.ActivityEditUserBinding
import com.example.test2.realmModel.ObjectUser
import com.example.test2.realmModel.UserDAO

class EditUserActivity : AppCompatActivity() {
    lateinit var binding:ActivityEditUserBinding
    var userDAO=UserDAO()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEditUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id=intent.getIntExtra("id",0)
        try {
            val data=userDAO.readById(id)
            val name:String?=data?.name
            val family:String?=data?.family
            binding.txtEditUserName.setText("$name")
            binding.txtEditUserFamily.setText("$family")
            
        }catch (ex:Exception){
            ex.printStackTrace()
        }


        binding.btnEditUserSave.setOnClickListener {
            if (binding.txtEditUserName.text.toString()=="" ||
                binding.txtEditUserFamily.text.toString()==""
            ){
                Toast.makeText(this, "لطفا فیلد های خالی را پر نمایید", Toast.LENGTH_SHORT).show()
            } else {
                editUser(id)
                finish()
            }

        }

    }

    private fun editUser(id:Int) {
        //Toast.makeText(this, "$id", Toast.LENGTH_SHORT).show()
        try {
            val objectUser=ObjectUser()
            objectUser.id=id
            objectUser.name=binding.txtEditUserName.text.toString()
            objectUser.family=binding.txtEditUserFamily.text.toString()
            userDAO.Update(objectUser)
        }catch (ex:Exception)
        {
            ex.printStackTrace()
        }
    }
}