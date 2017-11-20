package com.ledahl.androiddaggertest.injector.module;

import com.ledahl.androiddaggertest.service.RestService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RestServiceModule {

    @Singleton
    @Provides
    RestService provideRestService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RestService.class);
    }
}
