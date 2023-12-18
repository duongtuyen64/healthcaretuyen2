package com.example.healthcare2.viewmodel

import MedicineRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.healthcare2.data.model.Medicine

class MedicineViewModel(application: Application) : AndroidViewModel(application) {
    private val medicineRepository: MedicineRepository = MedicineRepository(application)
    fun getMedicine(idMedicine : Int) : LiveData<Medicine>{ return medicineRepository.getMedicine(idMedicine)}
}
