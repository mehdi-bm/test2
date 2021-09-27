package com.example.test2.ui.User


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.test2.R
import com.example.test2.databinding.FragmentAdduserBinding
import com.example.test2.realmModel.ObjectUser
import com.example.test2.realmModel.UserDAO

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddUserFragment : Fragment() {

    private var _binding: FragmentAdduserBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val userDAO=UserDAO()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAdduserBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnAddUserSave.setOnClickListener {
            if (binding.txtAddUserName.text.toString()=="" ||
                binding.txtAddUserFamily.text.toString()==""
                    ){
                Toast.makeText(activity, "لطفا فیلد های خالی را پر نمایید", Toast.LENGTH_SHORT).show()
            } else {
                addUser()
                findNavController().navigate(R.id.action_AddUserFragment_to_UserFragment)
            }
        }
    }

    private fun addUser() {
        val objectUser=ObjectUser()

      var id= userDAO.readAll().size

        id = if (id==0) 1 else id+1

        objectUser.id=id
        objectUser.name=binding.txtAddUserName.text.toString()
        objectUser.family=binding.txtAddUserFamily.text.toString()
        userDAO.Insert(objectUser)

    }

    override fun onDestroyView() {
        userDAO.CloseDB()
        super.onDestroyView()
        _binding = null

    }
}