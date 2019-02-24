package com.lisuperhong.openeye.mvp.contract

import com.company.commonbusiness.base.mvp.IMvpPresenter
import com.company.commonbusiness.base.mvp.IMvpView
import com.lisuperhong.openeye.mvp.model.bean.LightTopicBean

/**
 * Author: lisuperhong
 * Time: Create on 2018/9/23 23:00
 * Github: https://github.com/lisuperhong
 * Desc:
 */
interface SpecialTopicDetailContract {

    interface View : IMvpView {

        fun showSpecialTopicDetail(lightTopicBean: LightTopicBean)
    }

    interface Presenter : IMvpPresenter {

        fun getSpecialTopicDetail(url: String)
    }
}