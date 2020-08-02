package com.example.day03mvpchouqu.net;

import com.example.day03mvpchouqu.bean.NaviBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface WanService {
    String sWanUrl = "https://wanandroid.com/";

    //公众号tab
    //导航
    @GET("navi/json")
    Flowable<NaviBean> getNavi();
}
