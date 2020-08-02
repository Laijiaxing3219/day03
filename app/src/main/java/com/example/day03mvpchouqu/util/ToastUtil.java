package com.example.day03mvpchouqu.util;

import android.widget.Toast;

import com.example.day03mvpchouqu.base.BaseApp;

public class ToastUtil {
    public static void showToastShort(String msg){
        Toast.makeText(BaseApp.baseApp,msg,Toast.LENGTH_SHORT).show();
    }
    public static void showToastLong(String msg){
        Toast.makeText(BaseApp.baseApp,msg,Toast.LENGTH_LONG).show();
    }
}
