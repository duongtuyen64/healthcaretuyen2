package com.example.healthcare2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.healthcare2.data.model.AddMedicines;
import com.example.healthcare2.data.repository.AddMedicinesRepository;

import java.util.List;

public class AddMedicinesViewModel extends AndroidViewModel {
    private AddMedicinesRepository addMedicinesRepository;
    public AddMedicinesViewModel(@NonNull Application application) {
        super(application);
        addMedicinesRepository = new AddMedicinesRepository(application);
    }
    public LiveData<List<AddMedicines>> getAllAddMedicines(){
        return addMedicinesRepository.getMutiableLiveData();
    }
}