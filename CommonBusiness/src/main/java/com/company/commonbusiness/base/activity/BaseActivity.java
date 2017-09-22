package com.company.commonbusiness.base.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.company.commonbusiness.util.ActivityUtils;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author 李昭鸿
 * @desc: Activity基类
 * @date Created on 2017/7/21 10:27
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = this.getClass().getSimpleName();
    protected Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("onCreate Invoke...");
        ActivityUtils.addActivity(this);
        setContentView(getLayoutResId());
        unbinder = ButterKnife.bind(this);
        onViewCreated();

        if (null != getIntent()) {
            handleIntent(getIntent());
        }

        initView();
        initData(savedInstanceState);
    }

    protected void onViewCreated() {

    }

    /**
     * 处理跳转时传递的数据
     * @param intent
     */
    protected void handleIntent(Intent intent) {

    }

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d("onDestroy Invoke...");
        ActivityUtils.removeActivity(this);
        unbinder.unbind();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Logger.d("onLowMemory Invoke...");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Logger.d("onBackPressed Invoke...");
    }

    protected abstract int getLayoutResId();

    protected abstract void initView();

    protected abstract void initData(Bundle savedInstanceState);
}
