package com.example.healthcare2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.healthcare2.data.model.Notification;
import com.example.healthcare2.data.repository.NotificationRepository;

import java.util.List;

public class NotificationViewModel extends AndroidViewModel {
    private NotificationRepository notificationRepository;
    public NotificationViewModel(@NonNull Application application) {
        super(application);
        notificationRepository = new NotificationRepository(application);
    }
    public LiveData<List<Notification>> getAllNotification(){
        return notificationRepository.getMutiableLiveData();
    }
}