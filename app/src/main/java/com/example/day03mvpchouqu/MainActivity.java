package com.example.day03mvpchouqu;

import com.example.day03mvpchouqu.base.BaseActivity;
import com.example.day03mvpchouqu.presenter.MianPresenter;
import com.example.day03mvpchouqu.view.MianView;
/**
 * 1.gradle.properties 删掉
 * android.useAndroidX=true
 * # Automatically convert third-party libraries to use AndroidX
 * android.enableJetifier=true
 *
 * 2.依赖的东西换成27
 * 3.同步
 * 4.Actiivty,布局改成非androidx的
 *
 * 封装项目:
 * 1.选用框架,MVP,MVVM
 * 2.三方框架: HttpUrlConnection,xUtils,Volley,Ok,Retrofit ,Glide...
 * 3.工具类
 * 4.业务
 *
 *
 * 封装: 相同的类如果每次都需要写的东西可以封装到父类中
 */

/**
 * BaseActivity:
 * BasePresenter:
 * BaseModel:
 */
public class MainActivity extends BaseActivity<MianPresenter> implements MianView{



    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        //每一个V层都需要持有P层对象,并且将自己传到P层去
        //MainPresenter mainPresenter = new MainPresenter(this);
        //showLoading();
    }

    @Override
    protected MianPresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setData() {

    }


    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
