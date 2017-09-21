package com.company.commonbusiness.base.activity;

import com.company.commonbusiness.base.mvp.BasePresenter;
import com.company.commonbusiness.base.mvp.IMvpView;

/**
 * @author 李昭鸿
 * @desc: MVP模式Activity基类
 * @date Created on 2017/9/20 22:35
 * @github: https://github.com/lisuperhong
 */

public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements IMvpView {

    protected P presenter;

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        setPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
