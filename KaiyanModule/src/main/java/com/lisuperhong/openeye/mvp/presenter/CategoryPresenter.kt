package com.lisuperhong.openeye.mvp.presenter

import com.company.commonbusiness.base.mvp.BasePresenter
import com.company.commonbusiness.http.rx.BaseObserver
import com.lisuperhong.openeye.mvp.contract.CategoryContract
import com.lisuperhong.openeye.mvp.model.DataRepository
import com.lisuperhong.openeye.mvp.model.bean.BaseBean

/**
 * Author: lisuperhong
 * Time: Create on 2018/9/17 10:27
 * Github: https://github.com/lisuperhong
 * Desc: 分类
 */
class CategoryPresenter(rootView: CategoryContract.View) :
    BasePresenter<CategoryContract.View>(rootView),
    CategoryContract.Presenter {

    override fun getAllCategory() {
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
        DataRepository.instance.getCategories(observer)
    }

}