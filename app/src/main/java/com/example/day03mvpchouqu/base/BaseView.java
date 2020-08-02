package com.example.day03mvpchouqu.base;

public interface BaseView {
    void showToast(String msg);

    //显示loading
    void showLoading();

    //隐藏loading
    void hideLoading();
}
