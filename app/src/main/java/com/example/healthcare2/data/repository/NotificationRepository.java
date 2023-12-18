package com.example.healthcare2.data.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.healthcare2.data.api.RestApiService;
import com.example.healthcare2.data.api.RetrofitInstance;
import com.example.healthcare2.data.model.Notification;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationRepository {
    private Application application;

    private List<Notification> NotificationList = new ArrayList<>();
    private MutableLiveData<List<Notification>> mutableLiveData = new MutableLiveData<>();

    public NotificationRepository(Application application) {
        this.application = application;
    }
    public MutableLiveData<List<Notification>> getMutiableLiveData(){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<List<Notification>> call = apiService.getNotificationList();
        call.enqueue(new Callback<List<Notification>>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                if (response.body() != null){
                    NotificationList = response.body();
                    mutableLiveData.setValue(NotificationList);
                    Log.d("SUCCESS", NotificationList.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {
                Log.d("ERROR", "msg: " + t.getMessage());
                System.out.println("Lỗi: " + t.getMessage());
            }
        });
        return mutableLiveData;
    }
}
