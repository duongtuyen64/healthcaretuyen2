package com.example.healthcare2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.healthcare2.data.model.Rating
import com.example.healthcare2.data.repository.RatingRepository

class RatingViewModel (application: Application) : AndroidViewModel(application) {
    private val ratingRepository: RatingRepository = RatingRepository(application)
    fun getRatingCommentMedicine(idMedicine: Int) : LiveData<List<Rating>>{ return ratingRepository.getTop3RatingCommentMedicine(idMedicine)}
    fun addRatingMedicine(rating: Rating) {return ratingRepository.addRatingMedicine(rating)}
}