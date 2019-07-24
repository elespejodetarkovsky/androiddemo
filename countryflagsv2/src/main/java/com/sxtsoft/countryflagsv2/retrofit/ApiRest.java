package com.sxtsoft.countryflagsv2.retrofit;

import com.sxtsoft.countryflagsv2.model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiRest {

    @GET("all")
    public Call<List<Country>> getAll();

    @GET("alpha/{cod}")
    public Call<Country> getByAlphaCode(@Path("cod") String codigo);

}
