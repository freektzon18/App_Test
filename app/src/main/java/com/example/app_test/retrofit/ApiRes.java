package com.example.app_test.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRes {
    private static ApiService API_SERVICE;

    public static ApiService getApiService() {

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + "MzgYYQoiVPdHkMMJHoVgTKW4NRMi6gNfnVnZeHJujftH_0alJ8eLSvuSThNRgYg2DdEIgT-lS4ypzC0dVE8Gq158xIga86wikn8r0EU-0yr_AOHgmakqsy-iIZFhYnYx")
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        String baseUrl = "https://api.yelp.com/v3/";

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            API_SERVICE = retrofit.create(ApiService.class);
        }

        return API_SERVICE;
    }

}
