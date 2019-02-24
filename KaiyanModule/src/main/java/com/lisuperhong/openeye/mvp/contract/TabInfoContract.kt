package com.lisuperhong.openeye.mvp.contract

import com.company.commonbusiness.base.mvp.IMvpPresenter
import com.company.commonbusiness.base.mvp.IMvpView
import com.lisuperhong.openeye.mvp.model.bean.TabInfoBean

/**
 * Author: lisuperhong
 * Time: Create on 2018/9/14 23:00
 * Github: https://github.com/lisuperhong
 * Desc:
 */
interface TabInfoContract {

    interface View : IMvpView {
        /**
         * 显示tab信息
         */
        fun showTabInfo(tabInfoBean: TabInfoBean)
    }

    interface Presenter : IMvpPresenter {
        /**
         * 获取排行榜tab信息
         */
        fun getRankTabInfo()

        /**
         * 获取tag热门内容tab信息
         */
        fun getPopularTabInfo(url: String)
    }
}