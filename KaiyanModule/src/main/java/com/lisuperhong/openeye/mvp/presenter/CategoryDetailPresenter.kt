package com.lisuperhong.openeye.mvp.presenter

import com.company.commonbusiness.base.mvp.BasePresenter
import com.company.commonbusiness.http.rx.BaseObserver
import com.lisuperhong.openeye.mvp.contract.CategoryDetailContract
import com.lisuperhong.openeye.mvp.model.DataRepository
import com.lisuperhong.openeye.mvp.model.bean.BaseBean
import com.lisuperhong.openeye.mvp.model.bean.CategoryTabInfo

/**
 * Author: lisuperhong
 * Time: Create on 2018/9/20 22:54
 * Github: https://github.com/lisuperhong
 * Desc: 分类详情
 */
class CategoryDetailPresenter(rootView: CategoryDetailContract.View) :
    BasePresenter<CategoryDetailContract.View>(rootView),
    CategoryDetailContract.Presenter {

    override fun getCategoryInfo(id: Long) {
        checkViewAttached()
        val observer = object : BaseObserver<CategoryTabInfo>() {
            override fun onSuccess(data: CategoryTabInfo) {
                rootView?.showCategoryInfo(data)
            }

            override fun onFailure(errorMsg: String) {
                rootView?.hideLoading()
                rootView?.showMessage(errorMsg)
            }
        }
        addDispose(observer)
        DataRepository.instance.getCategoryInfo(id, observer)
    }

    override fun getVideoList(id: Long) {
        val observer = object : BaseObserver<BaseBean>() {
            override fun onSuccess(data: BaseBean) {
                rootView?.hideLoading()
                rootView?.showVideoList(data)
            }

            override fun onFailure(errorMsg: String) {
                rootView?.hideLoading()
                rootView?.showMessage(errorMsg)
            }
        }
        addDispose(observer)
        DataRepository.instance.getCategoryVideoList(id, observer)
    }

    override fun loadMore(url: String) {
        val observer = object : BaseObserver<BaseBean>() {
            override fun onSuccess(data: BaseBean) {
                rootView?.hideLoading()
                rootView?.showVideoList(data)
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