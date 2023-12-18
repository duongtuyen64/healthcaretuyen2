package com.example.healthcare2.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.healthcare2.data.api.RetrofitInstance
import com.example.healthcare2.data.model.Comment
import com.example.healthcare2.data.model.Rating
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RatingRepository (application: Application) {
    private var ratingMutableLiveData = MutableLiveData<List<Rating>>()
    private var listRating: List<Rating> = ArrayList<Rating>()
    fun getTop3RatingCommentMedicine(idMedicine: Int) : MutableLiveData<List<Rating>>{
        val apiService = RetrofitInstance.getApiService()
        val call : Call<List<Rating>> = apiService.getRatingCommentMedicine(idMedicine)
        call.enqueue(object : Callback<List<Rating>>{
            override fun onResponse(call: Call<List<Rating>>, response: Response<List<Rating>>) {
                if (response.body() != null) {
                    listRating = response.body()!!
                    ratingMutableLiveData.setValue(listRating)
                    Log.d("SUCCESS", listRating.toString())
                }
            }

            override fun onFailure(call: Call<List<Rating>>, t: Throwable) {
                Log.d("ERROR", "msg: " + t.message)
                println("Lỗi: " + t.message)
            }

        })
        return ratingMutableLiveData
    }
    fun addRatingMedicine(rating: Rating){
        val apiService = RetrofitInstance.getApiService()
        val call : Call<ResponseBody> = apiService.addRatingMedicine(rating)
        call.enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    Log.d("SUCCESS", "Add rating medicine: " + response.body().toString())
                    getTop3RatingCommentMedicine(rating.idMedicine)
                } else {
                    Log.d("ERROR", "Unsuccessful response: " + response.message())
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("ERROR", "msg: " + t.message)
                println("Lỗi: " + t.message)
            }

        })
    }
}