package com.example.day03mvpchouqu.net;

import com.example.day03mvpchouqu.util.LogUtil;
import com.example.day03mvpchouqu.util.ToastUtil;

import io.reactivex.subscribers.ResourceSubscriber;

public abstract class ResultSubscriber <T> extends ResourceSubscriber<T> {
    @Override
    public void onError(Throwable t) {
        ToastUtil.showToastShort(t.toString());
        LogUtil.print(t.toString());
    }

    @Override
    public void onComplete() {

    }
}
