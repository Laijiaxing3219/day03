package com.example.day03mvpchouqu.net;

public interface ResultCallBack<T> {
    void onSuccess(T t);
    void onFail(String msg);
}

