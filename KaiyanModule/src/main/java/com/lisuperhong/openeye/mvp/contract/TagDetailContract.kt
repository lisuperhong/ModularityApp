package com.lisuperhong.openeye.mvp.contract

import com.company.commonbusiness.base.mvp.IMvpPresenter
import com.company.commonbusiness.base.mvp.IMvpView
import com.lisuperhong.openeye.mvp.model.bean.BaseBean
import com.lisuperhong.openeye.mvp.model.bean.CategoryTabInfo

/**
 * Author: lisuperhong
 * Time: Create on 2018/9/23 01:18
 * Github: https://github.com/lisuperhong
 * Desc:
 */
interface TagDetailContract {

    interface View : IMvpView {

        fun showTagInfo(categoryTabInfo: CategoryTabInfo)

        fun showVideos(baseBean: BaseBean)
    }

    interface Presenter : IMvpPresenter {

        fun getTagInfo(id: Long)

        fun getVideos(id: Long)

        fun loadMore(url: String)
    }
}