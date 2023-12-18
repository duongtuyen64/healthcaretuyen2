package com.example.healthcare2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.healthcare2.data.model.AddPost;
import com.example.healthcare2.data.repository.AddPostRepository;

import java.util.List;

public class AddPostViewModel extends AndroidViewModel {
    private AddPostRepository addPostRepository;
    public AddPostViewModel(@NonNull Application application) {
        super(application);
        addPostRepository = new AddPostRepository(application);
    }
    public LiveData<List<AddPost>> getAllAddPost(){
        return addPostRepository.getMutiableLiveData();
    }
}