package com.example.day03mvpchouqu.util;

import android.util.Log;

import com.example.day03mvpchouqu.base.Constants;

public class LogUtil {
    public static void logD(String tag, String msg) {
        if (Constants.isDebug) {
            Log.d(tag, msg);
        }
    }

    public static void print(String msg){
        if (Constants.isDebug){
            System.out.println(msg);
        }
    }
}
