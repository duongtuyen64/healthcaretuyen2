package com.example.healthcare2.data.api;

import com.example.healthcare2.data.model.Comment;
import com.example.healthcare2.data.model.Doctor;
import com.example.healthcare2.data.model.Medicine;
import com.example.healthcare2.data.model.Rating;
import com.example.healthcare2.data.model.AddMedicines;
import com.example.healthcare2.data.model.AddPost;
import com.example.healthcare2.data.model.Notification;
import com.example.healthcare2.data.model.Post;
import com.example.healthcare2.data.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestApiService {
    @GET("userList")
    Call<List<User>> getUserList();

    @GET("doctor/{idUser}")
    Call<Doctor> getDoctor(@Path("idUser") int idUser);

    @GET("medicine/{idMedicine}")
    Call<Medicine> getMedicine(@Path("idMedicine") int idMedicine);

    @GET("commentMedicine/{idMedicine}")
    Call<List<Comment>> getCommentMedicine(@Path("idMedicine") int idMedicine);
    @GET("ratingCommentMedicine/{idMedicine}")
    Call<List<Rating>> getRatingCommentMedicine(@Path("idMedicine") int idMedicine);

    @POST("addCommentMedicine")
    Call<ResponseBody> addCommentMedicine(@Body Comment comment);
    @POST("addRatingMedicine")
    Call<ResponseBody> addRatingMedicine(@Body Rating rating);

    @GET("medicineList")
    Call<List<Medicine>> getMedicineList();

    @GET("notificationList")
    Call<List<Notification>> getNotificationList();

    @GET("postList")
    Call<List<Post>> getPostList();

    @GET("addPostList")
    Call<List<AddPost>> getAddPostList();

    @GET("addMedicinesList")
    Call<List<AddMedicines>> getAddMedicinesList();
}
