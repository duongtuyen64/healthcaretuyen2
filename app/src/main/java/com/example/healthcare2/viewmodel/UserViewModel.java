package com.example.healthcare2.viewmodel;

import android.app.Application;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.healthcare2.data.model.User;
import com.example.healthcare2.data.model.Doctor;
import com.example.healthcare2.data.repository.DoctorRepository;
import com.example.healthcare2.data.repository.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private DoctorRepository doctorRepository;
    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        doctorRepository = new DoctorRepository(application);
    }
    public LiveData<List<User>> getAllUser(){
        return userRepository.getMutiableLiveData();
    }
    public LiveData<Doctor> getDoctor(int idUser) {return doctorRepository.getDoctor(idUser);}
}