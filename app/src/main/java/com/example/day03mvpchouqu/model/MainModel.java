package com.example.day03mvpchouqu.model;

import com.example.day03mvpchouqu.base.BaseModel;
import com.example.day03mvpchouqu.bean.NaviBean;
import com.example.day03mvpchouqu.net.HttpUtil;
import com.example.day03mvpchouqu.net.ResultCallBack;
import com.example.day03mvpchouqu.net.ResultSubscriber;
import com.example.day03mvpchouqu.net.RxUtils;

public class MainModel extends BaseModel {
    public void getData(final ResultCallBack<NaviBean> callBack) {
        //resourceSubscriber就是subscribeWith里面传递的对象,ResourceSubscriber就是Disposable的子类
        //调用 Disposable.dispose()
        // 1.切断观察者和被观察者的连接,
        // 2.并且如果Rxjava配合Retrofit使用,它还可以取消网络请求
       /* ResourceSubscriber<NaviBean> resourceSubscriber = new Retrofit.Builder()
                .baseUrl(WanService.sWanUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WanService.class)
                .getNavi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResultSubscriber<NaviBean>() {
                    @Override
                    public void onNext(NaviBean naviBean) {
                        callBack.onSuccess(naviBean);
                    }
                });

        addDisposable(resourceSubscriber);
        */
        addDisposable(
                HttpUtil.getInstance()
                        .getWanService()
                        .getNavi()
                        /* .subscribeOn(Schedulers.io())
                         .observeOn(AndroidSchedulers.mainThread())*/
                        .compose(RxUtils.<NaviBean>rxSchedulerHelper())//切换线程
                        .subscribeWith(new ResultSubscriber<NaviBean>() {
                            @Override
                            public void onNext(NaviBean naviBean) {
                                callBack.onSuccess(naviBean);
                            }
                        })
        );
    }
}
