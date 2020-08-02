package com.example.day03mvpchouqu.presenter;


import com.example.day03mvpchouqu.base.BasePresenter;
import com.example.day03mvpchouqu.bean.NaviBean;
import com.example.day03mvpchouqu.model.LoginModel;
import com.example.day03mvpchouqu.model.MainModel;
import com.example.day03mvpchouqu.net.ResultCallBack;
import com.example.day03mvpchouqu.view.MianView;

public class MianPresenter extends BasePresenter<MianView> {
    private MainModel mMainModel;
    private LoginModel mLoginModel;

    public void getData(){
        mMainModel.getData(new ResultCallBack<NaviBean>() {
            @Override
            public void onSuccess(NaviBean naviBean) {

            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    //初始化M层的地方
    @Override
    protected void initModel() {
        mMainModel = new MainModel();
        mLoginModel = new LoginModel();
        addModel(mMainModel);
        addModel(mLoginModel);
    }

    public void login(){
        mLoginModel.login();
    }
}
