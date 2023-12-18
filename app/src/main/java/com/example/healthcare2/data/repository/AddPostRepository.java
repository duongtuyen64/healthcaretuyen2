package com.example.healthcare2.data.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.healthcare2.data.api.RestApiService;
import com.example.healthcare2.data.api.RetrofitInstance;
import com.example.healthcare2.data.model.AddPost;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPostRepository {
    private Application application;

    private List<AddPost> addPostList = new ArrayList<>();
    private MutableLiveData<List<AddPost>> mutableLiveData = new MutableLiveData<>();

    public AddPostRepository(Application application) {
        this.application = application;
    }
    public MutableLiveData<List<AddPost>> getMutiableLiveData(){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<List<AddPost>> call = apiService.getAddPostList();
        call.enqueue(new Callback<List<AddPost>>() {
            @Override
            public void onResponse(Call<List<AddPost>> call, Response<List<AddPost>> response) {
                if (response.body() != null){
                    addPostList = response.body();
                    mutableLiveData.setValue(addPostList);
                    Log.d("SUCCESS", addPostList.toString());
                }
            }

            @Override
            public void onFailure(Call<List<AddPost>> call, Throwable t) {
                Log.d("ERROR", "msg: " + t.getMessage());
                System.out.println("Lỗi: " + t.getMessage());
            }
        });
        return mutableLiveData;
    }
}