package com.company.commonbusiness.base.mvp;

import android.support.annotation.UiThread;

import java.lang.ref.WeakReference;

/**
 * @author 李昭鸿
 * @desc: Presenter基类，统一完成view的绑定及解绑
 * @date Created on 2017/7/21 10:22
 */

public class BasePresenter<V extends IMvpView> implements IMvpPresenter<V> {

    private WeakReference<V> viewRef;

    @UiThread
    @Override
    public void attachView(V view) {
        viewRef = new WeakReference<>(view);
    }

    @UiThread
    public V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    @UiThread
    public boolean isViewAttached() {
        return getView() != null;
    }

    @UiThread
    @Override
    public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    @Override
    public void unSubscibe() {

    }
}
