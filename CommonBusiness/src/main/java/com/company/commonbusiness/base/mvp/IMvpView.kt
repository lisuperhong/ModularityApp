package com.company.commonbusiness.base.mvp

/**
 * @author 李昭鸿
 * @desc: 所有Activity或者Fragment都要实现该接口
 * @date Created on 2017/7/21 10:03
 */

interface IMvpView {

    /**
     * 显示加载
     */
    fun showLoading()

    /**
     * 隐藏加载
     */
    fun hideLoading()

    /**
     * 显示信息
     */
    fun showMessage(message: String)
}
