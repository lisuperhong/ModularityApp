package com.lisuperhong.openeye.mvp.contract

import com.company.commonbusiness.base.mvp.IMvpPresenter
import com.company.commonbusiness.base.mvp.IMvpView
import com.lisuperhong.openeye.mvp.model.bean.BaseBean
import com.lisuperhong.openeye.mvp.model.bean.CategoryTabInfo

/**
 * Author: lisuperhong
 * Time: Create on 2018/9/20 22:49
 * Github: https://github.com/lisuperhong
 * Desc:
 */
interface CategoryDetailContract {

    interface View : IMvpView {

        fun showCategoryInfo(categoryTabInfo: CategoryTabInfo)

        fun showVideoList(baseBean: BaseBean)
    }

    interface Presenter : IMvpPresenter {

        fun getCategoryInfo(id: Long)

        fun getVideoList(id: Long)

        fun loadMore(url: String)
    }
}