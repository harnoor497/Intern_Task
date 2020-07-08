package com.example.intern_task;

import com.example.intern_task.ResObj;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface UsrSrvc {

    @POST("/")
    Call login(@Path("mobile") String mobile, @Path("password") String password);


}
