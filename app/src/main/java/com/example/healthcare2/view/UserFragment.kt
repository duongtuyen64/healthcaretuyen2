package com.example.healthcare2.view
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.healthcare2.databinding.FragmentUserBinding
import com.example.healthcare2.viewmodel.UserViewModel

class UserFragment : Fragment() {
    private lateinit var binding: FragmentUserBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(layoutInflater)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        getDoctor(1)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    fun getUserList(){
        userViewModel.allUser.observe(viewLifecycleOwner) { userList ->
            binding.txtUser.text = userList.toString()
        }
    }
    fun getDoctor(idUser : Int){
        userViewModel.getDoctor(idUser).observe(viewLifecycleOwner) { doctor ->
            binding.txtUser.text = doctor.toString()
        }
    }
}