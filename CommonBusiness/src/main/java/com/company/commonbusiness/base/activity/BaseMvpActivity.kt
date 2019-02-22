package com.company.commonbusiness.base.activity

import com.company.commonbusiness.base.mvp.IMvpPresenter

/**
 * @author 李昭鸿
 * @desc: MVP模式Activity基类
 * @date Created on 2017/9/20 22:35
 * @github: https://github.com/lisuperhong
 */

abstract class BaseMvpActivity<P : IMvpPresenter> : BaseActivity() {

    protected var presenter: P? = null

    override fun onDestroy() {
        super.onDestroy()
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
