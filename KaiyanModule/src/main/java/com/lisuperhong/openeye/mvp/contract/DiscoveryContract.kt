package com.lisuperhong.openeye.mvp.contract

import com.company.commonbusiness.base.mvp.IMvpPresenter
import com.company.commonbusiness.base.mvp.IMvpView
import com.lisuperhong.openeye.mvp.model.bean.BaseBean

/**
 * Author: lisuperhong
 * Time: Create on 2018/8/11 17:36
 * Github: https://github.com/lisuperhong
 * Desc:
 */
interface DiscoveryContract {

    interface View : IMvpView {
        /**
         * 显示推荐数据
         */
        fun showContent(baseBean: BaseBean)
    }

    interface Presenter : IMvpPresenter {

        /**
         * 获取数据
         */
        fun discovery()
    }
}