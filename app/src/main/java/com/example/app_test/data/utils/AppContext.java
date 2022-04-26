package com.example.app_test.data.utils;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class AppContext extends Application {

    private static Context myApplicationContext;
    private static AppContext instance;


    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        myApplicationContext = this;
    }

    public static AppContext getInstance() {
        if (instance== null) {
            synchronized(AppContext.class) {
                if (instance == null)
                    instance = new AppContext();
            }
        }
        return instance;
    }

    public static Context getMyApplicationContext(){
        return myApplicationContext;
    }

}
