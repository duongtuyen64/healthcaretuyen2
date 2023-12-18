package com.example.healthcare2.view
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.healthcare2.R
import com.example.healthcare2.databinding.FragmentAddPostBinding
import com.example.healthcare2.viewmodel.AddPostViewModel

class AddPostFragmentFragment : Fragment() {
    private lateinit var binding: FragmentAddPostBinding
    private lateinit var addPostViewModel: AddPostViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPostBinding.inflate(layoutInflater)
        addPostViewModel = ViewModelProvider(this).get(AddPostViewModel::class.java)
        getAddPostList()
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    fun getAddPostList(){
        addPostViewModel.allAddPost.observe(viewLifecycleOwner) { addPostList ->
            binding.addpost.findViewById<ConstraintLayout>(R.id.addpost)
        }
    }
}