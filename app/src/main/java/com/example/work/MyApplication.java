package com.example.work;

import android.app.Application;

import com.example.work.di.AppContainer;

public class MyApplication extends Application {

    public AppContainer appContainer;
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void setUpComponents() {
        appContainer = new AppContainer(this);
    }
}
