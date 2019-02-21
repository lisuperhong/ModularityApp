package com.company.commonbusiness.base.fragment

import com.company.commonbusiness.base.mvp.IMvpPresenter

/**
 * @author 李昭鸿
 * @desc: MVP模式的Fragment基类
 * @date Created on 2017/9/21 18:39
 * @github: https://github.com/lisuperhong
 */

abstract class BaseMvpFragment<P : IMvpPresenter> : BaseFragment() {

    protected var presenter: P? = null

    override fun onDestroyView() {
        super.onDestroyView()
        if (presenter != null) {
            presenter!!.detachView() //释放资源
        }
        presenter = null
    }

    /**
     * 绑定Presenter
     */
    protected abstract fun setPresenter()
}