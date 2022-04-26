package com.example.app_test.retrofit;

import com.example.app_test.data.request.RequestSearch;
import com.example.app_test.data.response.ResponseSearch;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    //?term=delis&latitude=37.786882&longitude=-122.399972
    @GET("businesses/search")
    Call<ResponseSearch> getBusinesses(@Query("term") String term, @Query("latitude") String latitud, @Query("longitude") String longitud);

}
