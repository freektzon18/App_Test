package com.example.app_test.data.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.app_test.ListToBusiness;
import com.example.app_test.data.repository.RepositoryYelp;
import com.example.app_test.data.response.Businesses;
import com.example.app_test.data.response.ResponseSearch;

import java.util.List;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private LiveData<List<Businesses>> listLiveData;
    private RepositoryYelp repo;

    public ViewModel() {
        this.repo = new RepositoryYelp();
        this.listLiveData = repo.getList();
    }


    public void searchBusinesses(String search, String lat, String lng){
        repo.searchBusinesses(search,lat,lng);
    }

    public LiveData<List<Businesses>> getBussines(){
        return listLiveData;
    }
}
