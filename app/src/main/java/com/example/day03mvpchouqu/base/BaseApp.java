package com.example.day03mvpchouqu.base;

import android.app.Application;

public class BaseApp extends Application {
    public static BaseApp baseApp;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApp=this;
    }
}
