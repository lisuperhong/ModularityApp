package com.lisuperhong.openeye.mvp.presenter

import com.company.commonbusiness.base.mvp.BasePresenter
import com.company.commonbusiness.http.rx.BaseObserver
import com.lisuperhong.openeye.mvp.contract.TagDetailContract
import com.lisuperhong.openeye.mvp.model.DataRepository
import com.lisuperhong.openeye.mvp.model.bean.BaseBean
import com.lisuperhong.openeye.mvp.model.bean.CategoryTabInfo

/**
 * Author: lisuperhong
 * Time: Create on 2018/9/23 01:21
 * Github: https://github.com/lisuperhong
 * Desc: 标签详情
 */
class TagDetailPresenter(rootView: TagDetailContract.View) :
    BasePresenter<TagDetailContract.View>(rootView), TagDetailContract.Presenter {

    override fun getTagInfo(id: Long) {
        checkViewAttached()
        val observer = object : BaseObserver<CategoryTabInfo>() {
            override fun onSuccess(data: CategoryTabInfo) {
                rootView?.showTagInfo(data)
            }

            override fun onFailure(errorMsg: String) {
                rootView?.hideLoading()
                rootView?.showMessage(errorMsg)
            }
        }
        addDispose(observer)
        DataRepository.instance.getTagInfo(id, observer)
    }

    override fun getVideos(id: Long) {
        val observer = object : BaseObserver<BaseBean>() {
            override fun onSuccess(data: BaseBean) {
                rootView?.hideLoading()
                rootView?.showVideos(data)
            }

            override fun onFailure(errorMsg: String) {
                rootView?.hideLoading()
                rootView?.showMessage(errorMsg)
            }
        }
        addDispose(observer)
        DataRepository.instance.getTagVideos(id, observer)
    }

    override fun loadMore(url: String) {
        val observer = object : BaseObserver<BaseBean>() {
            override fun onSuccess(data: BaseBean) {
                rootView?.hideLoading()
                rootView?.showVideos(data)
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