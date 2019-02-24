package com.lisuperhong.openeye.mvp.presenter

import com.company.commonbusiness.base.mvp.BasePresenter
import com.company.commonbusiness.http.rx.BaseObserver
import com.lisuperhong.openeye.mvp.contract.SpecialTopicsContract
import com.lisuperhong.openeye.mvp.model.DataRepository
import com.lisuperhong.openeye.mvp.model.bean.BaseBean

/**
 * Author: lisuperhong
 * Time: Create on 2018/9/23 18:14
 * Github: https://github.com/lisuperhong
 * Desc: 热门专题列表
 */
class SpecialTopicsPresenter(rootView: SpecialTopicsContract.View) :
    BasePresenter<SpecialTopicsContract.View>(rootView),
    SpecialTopicsContract.Presenter {

    override fun getSpecialTopics() {
        checkViewAttached()
        val observer = object : BaseObserver<BaseBean>() {
            override fun onSuccess(data: BaseBean) {
                rootView?.hideLoading()
                rootView?.showSpecialTopics(data)
            }

            override fun onFailure(errorMsg: String) {
                rootView?.hideLoading()
                rootView?.showMessage(errorMsg)
            }
        }
        addDispose(observer)
        DataRepository.instance.getSpecialTopics(observer)
    }
}