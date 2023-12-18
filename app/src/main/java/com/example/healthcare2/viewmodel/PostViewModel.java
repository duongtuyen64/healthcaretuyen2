package com.example.healthcare2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.healthcare2.data.model.Post;
import com.example.healthcare2.data.repository.PostRepository;

import java.util.List;

public class PostViewModel extends AndroidViewModel {
    private PostRepository userRepository;
    public PostViewModel(@NonNull Application application) {
        super(application);
        userRepository = new PostRepository(application);
    }
    public LiveData<List<Post>> getAllPost(){
        return userRepository.getMutiableLiveData();
    }
}