package com.lisuperhong.openeye.mvp.contract

import com.company.commonbusiness.base.mvp.IMvpPresenter
import com.company.commonbusiness.base.mvp.IMvpView
import com.lisuperhong.openeye.mvp.model.bean.BaseBean

/**
 * Author: lisuperhong
 * Time: Create on 2018/9/17 10:22
 * Github: https://github.com/lisuperhong
 * Desc:
 */
interface CategoryContract {

    interface View : IMvpView {

        fun showContent(baseBean: BaseBean)
    }

    interface Presenter : IMvpPresenter {

        fun getAllCategory()
    }
}