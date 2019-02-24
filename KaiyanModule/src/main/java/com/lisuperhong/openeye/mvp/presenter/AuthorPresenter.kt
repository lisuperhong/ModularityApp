package com.lisuperhong.openeye.mvp.presenter

import com.company.commonbusiness.base.mvp.BasePresenter
import com.company.commonbusiness.http.rx.BaseObserver
import com.lisuperhong.openeye.mvp.contract.AuthorContract
import com.lisuperhong.openeye.mvp.model.DataRepository
import com.lisuperhong.openeye.mvp.model.bean.BaseBean

/**
 * Author: lizhaohong
 * Time: Create on 2018/10/22 17:38
 * Desc: 全部作者
 */
class AuthorPresenter(rootView: AuthorContract.View) : BasePresenter<AuthorContract.View>(rootView),
    AuthorContract.Presenter {

    override fun allAuthors() {
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
        DataRepository.instance.getAllAuthors(observer)
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
        DataRepository.instance.loadMoreAuthors(url, observer)
    }
}