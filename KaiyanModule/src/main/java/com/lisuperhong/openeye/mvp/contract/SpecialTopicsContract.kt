package com.lisuperhong.openeye.mvp.contract

import com.company.commonbusiness.base.mvp.IMvpPresenter
import com.company.commonbusiness.base.mvp.IMvpView
import com.lisuperhong.openeye.mvp.model.bean.BaseBean

/**
 * Author: lisuperhong
 * Time: Create on 2018/9/23 18:11
 * Github: https://github.com/lisuperhong
 * Desc:
 */
interface SpecialTopicsContract {

    interface View : IMvpView {

        fun showSpecialTopics(bean: BaseBean)
    }

    interface Presenter : IMvpPresenter {

        fun getSpecialTopics()
    }
}