package com.example.app_test.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.app_test.data.response.Businesses;
import com.example.app_test.data.response.ResponseSearch;
import com.example.app_test.retrofit.ApiRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryYelp {

    private MutableLiveData<List<Businesses>> listBusisn;

    public RepositoryYelp() {
        this.listBusisn = new MutableLiveData<>();
    }

    public LiveData<List<Businesses>> getList(){
        return listBusisn;
    }

    public void searchBusinesses(String search, String lat, String lng){
        Call<ResponseSearch> call = ApiRes.getApiService().getBusinesses(search,lat,lng);
        call.enqueue(new Callback<ResponseSearch>() {
            @Override
            public void onResponse(Call<ResponseSearch> call, Response<ResponseSearch> response) {
                if (response.isSuccessful()){
                    listBusisn.postValue(response.body().getBusinesses());
                }else {
                    listBusisn.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseSearch> call, Throwable t) {
                listBusisn.postValue(null);
            }
        });
    }
}
