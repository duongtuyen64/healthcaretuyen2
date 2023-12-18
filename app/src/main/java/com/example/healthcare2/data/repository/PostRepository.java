package com.example.healthcare2.data.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.healthcare2.data.api.RestApiService;
import com.example.healthcare2.data.api.RetrofitInstance;
import com.example.healthcare2.data.model.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {
    private Application application;

    private List<Post> postList = new ArrayList<>();
    private MutableLiveData<List<Post>> mutableLiveData = new MutableLiveData<>();

    public PostRepository(Application application) {
        this.application = application;
    }
    public MutableLiveData<List<Post>> getMutiableLiveData(){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<List<Post>> call = apiService.getPostList();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.body() != null){
                    postList = response.body();
                    mutableLiveData.setValue(postList);
                    Log.d("SUCCESS", postList.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("ERROR", "msg: " + t.getMessage());
                System.out.println("Lỗi: " + t.getMessage());
            }
        });
        return mutableLiveData;
    }
}