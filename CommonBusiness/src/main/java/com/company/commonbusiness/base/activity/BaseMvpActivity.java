package com.company.commonbusiness.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.company.commonbusiness.base.mvp.MvpBasePresenter;
import com.company.commonbusiness.log.XLog;
import com.company.commonbusiness.util.ActivityUtils;

/**
 * @author 李昭鸿
 * @desc: MVP模式Activity基类
 * @date Created on 2017/9/20 22:35
 * @github: https://github.com/lisuperhong
 */

public abstract class BaseMvpActivity<P extends MvpBasePresenter> extends BaseActivity {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        XLog.d(TAG, "onDestroy Invoke...");
        ActivityUtils.removeActivity(this);
        presenter.detachView();
        presenter.unSubscibe();
    }
}
