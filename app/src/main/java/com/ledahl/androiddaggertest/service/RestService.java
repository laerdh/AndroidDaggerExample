package com.ledahl.androiddaggertest.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RestService {

    @POST("/postSomeData")
    Call<Void> postSomeData(@Body String data);
}
