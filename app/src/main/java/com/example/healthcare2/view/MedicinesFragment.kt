package com.example.healthcare2.view
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.healthcare2.R
import com.example.healthcare2.adapter.MedicinesAdapter
import com.example.healthcare2.databinding.FragmentMedicinesBinding
import com.example.healthcare2.viewmodel.MedicineViewModel

class MedicinesFragment : Fragment() {
    private lateinit var binding: FragmentMedicinesBinding
    private lateinit var medicineViewModel: MedicineViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMedicinesBinding.inflate(layoutInflater)
        medicineViewModel = ViewModelProvider(this).get(MedicineViewModel::class.java)
        getMedicineList()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun getMedicineList() {
        medicineViewModel.getMedicine(idMedicine = 1).observe(viewLifecycleOwner) { medicine ->
            medicine?.let {
                val medicinesAdapter = MedicinesAdapter(requireContext(), listOf(it), R.layout.item_medicines)
                binding.recyclerViewMedicines.adapter = medicinesAdapter
            }
        }
    }
}