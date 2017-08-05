package com.company.commonbusiness.base.mvp;

/**
 * @author 李昭鸿
 * @desc: 完成View与Presenter的绑定和解除绑定
 * @date Created on 2017/7/21 10:08
 */

public interface IMvpPresenter<V> {

    void attachView(V view);

    void detachView();

    void unSubscibe();
}
