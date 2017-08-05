package com.company.commonbusiness.base.mvp;

/**
 * @author 李昭鸿
 * @desc: 所有Activity或者Fragment都要实现该接口
 * @date Created on 2017/7/21 10:03
 */

public interface IMvpView<P> {

    void setPresenter(P presenter);
}
