package com.lisuperhong.openeye.mvp.presenter

import com.company.commonbusiness.base.mvp.BasePresenter
import com.company.commonbusiness.http.rx.BaseObserver
import com.lisuperhong.openeye.mvp.contract.TabRankContract
import com.lisuperhong.openeye.mvp.model.DataRepository
import com.lisuperhong.openeye.mvp.model.bean.BaseBean

/**
 * Author: lisuperhong
 * Time: Create on 2018/9/14 23:40
 * Github: https://github.com/lisuperhong
 * Desc: 排行榜
 */
class TabRankPresenter(rootView: TabRankContract.View) :
    BasePresenter<TabRankContract.View>(rootView), TabRankContract.Presenter {

    override fun requestRankList(apiUrl: String) {
        checkViewAttached()
        val observer = object : BaseObserver<BaseBean>() {
            override fun onSuccess(data: BaseBean) {
                rootView?.hideLoading()
                rootView?.showContent(data)
            }

            override fun onFailure(errorMsg: String) {
                rootView?.hideLoading()
                rootView?.showMessage(errorMsg)
            }
        }
        addDispose(observer)
        DataRepository.instance.loadMoreData(apiUrl, observer)
    }
}