package com.lisuperhong.openeye.mvp.presenter

import com.company.commonbusiness.base.mvp.BasePresenter
import com.company.commonbusiness.http.rx.BaseObserver
import com.lisuperhong.openeye.mvp.contract.RecommendContract
import com.lisuperhong.openeye.mvp.model.DataRepository
import com.lisuperhong.openeye.mvp.model.bean.BaseBean

/**
 * Author: lisuperhong
 * Time: Create on 2018/8/5 13:58
 * Github: https://github.com/lisuperhong
 * Desc: 推荐
 */
class RecommendPresenter(rootView: RecommendContract.View) :
    BasePresenter<RecommendContract.View>(rootView),
    RecommendContract.Presenter {

    override fun requestAllRec(page: Int) {
        // 检测是否绑定 View
        checkViewAttached()
        val observer = object : BaseObserver<BaseBean>() {
            override fun onSuccess(data: BaseBean) {
                rootView?.hideLoading()
                rootView?.showContent(data)
            }

            override fun onFailure(errorMsg: String) {
                rootView?.showMessage(errorMsg)
                rootView?.hideLoading()
            }
        }
        addDispose(observer)
        DataRepository.instance.allRec(page, observer)
    }

    override fun loadMoreData(url: String) {
        checkViewAttached()
        val observer = object : BaseObserver<BaseBean>() {
            override fun onSuccess(data: BaseBean) {
                rootView?.showContent(data)
            }

            override fun onFailure(errorMsg: String) {
                rootView?.showMessage(errorMsg)
            }
        }
        addDispose(observer)
        DataRepository.instance.loadMoreData(url, observer)
    }
}