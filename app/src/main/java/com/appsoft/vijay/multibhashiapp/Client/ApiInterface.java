package com.appsoft.vijay.multibhashiapp.Client;

import com.appsoft.vijay.multibhashiapp.Model.Lesson_Data;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ATUL on 21-Apr-18.
 */

public interface ApiInterface {
    @GET("/getLessonData.php")
    Call<Lesson_Data> getLessonDataFromServer();
}
