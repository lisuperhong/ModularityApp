package com.company.commonbusiness.base.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.company.commonbusiness.log.XLog;
import com.company.commonbusiness.util.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author 李昭鸿
 * @desc: Activity基类
 * @date Created on 2017/7/21 10:27
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = this.getClass().getSimpleName();
    private Unbinder unbinder;
//    private P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XLog.d(TAG, "onCreate Invoke...");
        ActivityUtils.addActivity(this);
        setContentView(getLayoutResId());
        unbinder = ButterKnife.bind(this);

        if (null != getIntent()) {
            handleIntent(getIntent());
        }
        initView();
        initData();
    }

//    @Override
//    public void setPresenter(P presenter) {
//        this.p = presenter;
//        p.attachView(this);
//    }

    /**
     * 处理跳转时传递的数据
     * @param intent
     */
    protected void handleIntent(Intent intent) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        XLog.d(TAG, "onDestroy Invoke...");
        ActivityUtils.removeActivity(this);
        unbinder.unbind();
//        p.detachView();
//        p.unSubscibe();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        XLog.d(TAG, "onLowMemory Invoke...");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        XLog.d(TAG, "onBackPressed Invoke...");
    }

    public abstract int getLayoutResId();

    public abstract int initView();

    public abstract int initData();
}
