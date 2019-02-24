package com.lisuperhong.openeye.mvp.presenter

import com.company.commonbusiness.base.mvp.BasePresenter
import com.company.commonbusiness.http.rx.BaseObserver
import com.lisuperhong.openeye.mvp.contract.ProductionContract
import com.lisuperhong.openeye.mvp.model.DataRepository
import com.lisuperhong.openeye.mvp.model.bean.BaseBean

/**
 * Author: lisuperhong
 * Time: Create on 2018/9/16 00:36
 * Github: https://github.com/lisuperhong
 * Desc:
 */
class ProductionPresenter(rootView: ProductionContract.View) :
    BasePresenter<ProductionContract.View>(rootView),
    ProductionContract.Presenter {

    override fun communityFollow() {
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
        DataRepository.instance.getCommunityFollow(observer)
    }

    override fun followLoadMore(url: String) {
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
        DataRepository.instance.loadMoreData(url, observer)
    }
}