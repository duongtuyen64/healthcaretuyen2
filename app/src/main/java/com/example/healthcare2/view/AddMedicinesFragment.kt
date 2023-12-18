package com.example.healthcare2.view
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.healthcare2.R
import com.example.healthcare2.databinding.FragmentAddMedicinesBinding
import com.example.healthcare2.viewmodel.AddMedicinesViewModel

class AddMedicinesFragmentFragment : Fragment() {
    private lateinit var binding: FragmentAddMedicinesBinding
    private lateinit var addMedicinesViewModel: AddMedicinesViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddMedicinesBinding.inflate(layoutInflater)
        addMedicinesViewModel = ViewModelProvider(this).get(AddMedicinesViewModel::class.java)
        getAddMedicinesList()
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    fun getAddMedicinesList(){
        addMedicinesViewModel.allAddMedicines.observe(viewLifecycleOwner) { addMedicinesList ->
            binding.addmedicines.findViewById<ConstraintLayout>(R.id.addmedicines)
        }
    }
}