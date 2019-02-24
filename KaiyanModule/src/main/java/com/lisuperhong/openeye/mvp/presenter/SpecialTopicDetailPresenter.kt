package com.lisuperhong.openeye.mvp.presenter

import com.company.commonbusiness.base.mvp.BasePresenter
import com.company.commonbusiness.http.rx.BaseObserver
import com.lisuperhong.openeye.mvp.contract.SpecialTopicDetailContract
import com.lisuperhong.openeye.mvp.model.DataRepository
import com.lisuperhong.openeye.mvp.model.bean.LightTopicBean

/**
 * Author: lisuperhong
 * Time: Create on 2018/9/23 23:02
 * Github: https://github.com/lisuperhong
 * Desc: 热门专题详情
 */
class SpecialTopicDetailPresenter(rootView: SpecialTopicDetailContract.View) :
    BasePresenter<SpecialTopicDetailContract.View>(rootView),
    SpecialTopicDetailContract.Presenter {

    override fun getSpecialTopicDetail(url: String) {
        checkViewAttached()
        val observer = object : BaseObserver<LightTopicBean>() {
            override fun onSuccess(data: LightTopicBean) {
                rootView?.hideLoading()
                rootView?.showSpecialTopicDetail(data)
            }

            override fun onFailure(errorMsg: String) {
                rootView?.hideLoading()
                rootView?.showMessage(errorMsg)
            }
        }
        addDispose(observer)
        DataRepository.instance.getSpecialTopicDetail(url, observer)
    }
}