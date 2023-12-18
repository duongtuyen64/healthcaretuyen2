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

class CommentRepository (application: Application) {
    private var commentMutableLiveData = MutableLiveData<List<Comment>>()
    private var listComment: List<Comment> = ArrayList<Comment>()
    fun getCommentMecicidne(idMedicine: Int) : MutableLiveData<List<Comment>>{
        val apiService = RetrofitInstance.getApiService()
        val call : Call<List<Comment>> = apiService.getCommentMedicine(idMedicine)
        call.enqueue(object: Callback<List<Comment>>{
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if (response.body() != null) {
                    listComment = response.body()!!
                    commentMutableLiveData.setValue(listComment)
                    Log.d("SUCCESS", listComment.toString())
                }
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Log.d("ERROR", "msg: " + t.message)
                println("Lỗi: " + t.message)
            }

        })
        return commentMutableLiveData
    }
    fun addCommentMedicine(comment: Comment) {
        val apiService = RetrofitInstance.getApiService()
        val call : Call<ResponseBody> = apiService.addCommentMedicine(comment)
        call.enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    Log.d("SUCCESS", "Add comment medicine: " + response.body().toString())
                    getCommentMecicidne(comment.idMedicine)
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