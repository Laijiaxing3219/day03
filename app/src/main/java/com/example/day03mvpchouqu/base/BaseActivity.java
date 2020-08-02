package com.example.day03mvpchouqu.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.day03mvpchouqu.widget.LoadingDialog;

import butterknife.ButterKnife;
import io.reactivex.annotations.Nullable;

public abstract class BaseActivity <P extends BasePresenter>extends AppCompatActivity implements BaseView{

    public P mPresenter;
    private LoadingDialog mLoadingDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        mPresenter = initPresenter();
        if (mPresenter != null) {
            //将V层的对象给到P层
            mPresenter.bindView(this);
        }

        initView();
        initListener();
        initData();
    }

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.destroy();
            mPresenter = null;
        }

        hideLoading();
    }

}
