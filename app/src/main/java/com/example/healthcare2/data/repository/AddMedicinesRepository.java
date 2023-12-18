package com.example.healthcare2.data.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.healthcare2.data.api.RestApiService;
import com.example.healthcare2.data.api.RetrofitInstance;
import com.example.healthcare2.data.model.AddMedicines;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMedicinesRepository {
    private Application application;

    private List<AddMedicines> addMedicinesList = new ArrayList<>();
    private MutableLiveData<List<AddMedicines>> mutableLiveData = new MutableLiveData<>();

    public AddMedicinesRepository(Application application) {
        this.application = application;
    }
    public MutableLiveData<List<AddMedicines>> getMutiableLiveData(){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<List<AddMedicines>> call = apiService.getAddMedicinesList();
        call.enqueue(new Callback<List<AddMedicines>>() {
            @Override
            public void onResponse(Call<List<AddMedicines>> call, Response<List<AddMedicines>> response) {
                if (response.body() != null){
                    addMedicinesList = response.body();
                    mutableLiveData.setValue(addMedicinesList);
                    Log.d("SUCCESS", addMedicinesList.toString());
                }
            }

            @Override
            public void onFailure(Call<List<AddMedicines>> call, Throwable t) {
                Log.d("ERROR", "msg: " + t.getMessage());
                System.out.println("Lỗi: " + t.getMessage());
            }
        });
        return mutableLiveData;
    }
}