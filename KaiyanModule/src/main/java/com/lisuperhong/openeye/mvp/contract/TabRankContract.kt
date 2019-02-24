package com.lisuperhong.openeye.mvp.contract

import com.company.commonbusiness.base.mvp.IMvpPresenter
import com.company.commonbusiness.base.mvp.IMvpView
import com.lisuperhong.openeye.mvp.model.bean.BaseBean

/**
 * Author: lisuperhong
 * Time: Create on 2018/9/14 23:30
 * Github: https://github.com/lisuperhong
 * Desc:
 */
interface TabRankContract {

    interface View : IMvpView {
        /**
         * 显示推荐数据
         */
        fun showContent(baseBean: BaseBean)
    }

    interface Presenter : IMvpPresenter {
        /**
         * 获取排行视频信息
         */
        fun requestRankList(apiUrl: String)
    }
}