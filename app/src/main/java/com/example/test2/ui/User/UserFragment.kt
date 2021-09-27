package com.example.test2.ui.User

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test2.R
import com.example.test2.databinding.FragmentUserBinding
import com.example.test2.realmModel.UserDAO
import com.example.test2.utils.DataModelUser
import com.example.test2.utils.UserAdapter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val userDAO= UserDAO()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FillData()


        binding.fav1.setOnClickListener {
            findNavController().navigate(R.id.action_UserFragment_to_AddUserFragment)
        }
    }
    @SuppressLint("UseRequireInsteadOfGet")
    fun FillData(){
        try {
            val result=userDAO.readAll()
            if (result.size>0){
                val adapter=UserAdapter(result, activity!!)
                binding.recyclerUser.layoutManager= LinearLayoutManager(activity)
                binding.recyclerUser.adapter=adapter
            }




        }catch (ex:Exception){
            ex.printStackTrace()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}