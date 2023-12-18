package com.example.healthcare2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.healthcare2.data.model.Comment
import com.example.healthcare2.data.model.Rating
import com.example.healthcare2.data.repository.CommentRepository

class CommentViewModel(application: Application) : AndroidViewModel(application) {
    private val commentRepository: CommentRepository = CommentRepository(application)
    fun getCommentMedicine(idMedicine: Int) : LiveData<List<Comment>>{ return commentRepository.getCommentMecicidne(idMedicine)}
    fun addCommentMedicine(comment: Comment)  { return commentRepository.addCommentMedicine(comment)}
}