package com.sxtsoft.medicdatav3.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET("lecturas/10")
    Call<List<Lectura>> getAll();

    @Headers("Content-type:application/json")
    @POST("lecturas/10")
    Call<Lectura> createPost(@Body Lectura lectura);

}