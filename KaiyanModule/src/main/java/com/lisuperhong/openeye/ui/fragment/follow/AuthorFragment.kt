package com.lisuperhong.openeye.ui.fragment.follow

import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.company.commonbusiness.base.fragment.BaseMvpFragment
import com.lisuperhong.openeye.R
import com.lisuperhong.openeye.mvp.contract.AuthorContract
import com.lisuperhong.openeye.mvp.model.bean.BaseBean
import com.lisuperhong.openeye.mvp.presenter.AuthorPresenter
import com.lisuperhong.openeye.ui.adapter.MultiItemAdapter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import kotlinx.android.synthetic.main.fragment_author.*

/**
 * Author: lizhaohong
 * Time: Create on 2018/10/17 15:01
 * Desc: 全部作者
 */
class AuthorFragment : BaseMvpFragment<AuthorPresenter>(), AuthorContract.View {

    private var multiItemAdapter: MultiItemAdapter? = null
    private var isRefresh = false
    private var nextPageUrl: String? = null

    override val layoutId: Int
        get() = R.layout.fragment_author

    override fun setPresenter() {
        presenter = AuthorPresenter(this)
    }

    override fun initView() {
        refreshLayout.setRefreshHeader(ClassicsHeader(activity))
        refreshLayout.setEnableAutoLoadMore(true)
        refreshLayout.setOnRefreshListener {
            isRefresh = true
            initData()
        }

        refreshLayout.setOnLoadMoreListener {
            isRefresh = false
            if (nextPageUrl != null) {
                presenter?.followLoadMore(nextPageUrl!!)
            } else {
                refreshLayout.setEnableLoadMore(false)
            }
        }

        multiItemAdapter = MultiItemAdapter(getContext()!!, ArrayList<BaseBean.Item>())
        authorRecycleView.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        authorRecycleView.adapter = multiItemAdapter
        isRefresh = false
        showLoading()
    }

    override fun initData() {
        presenter?.allAuthors()
    }

    override fun showContent(baseBean: BaseBean) {
        stopRefresh()
        if (baseBean.itemList.isEmpty())
            return
        nextPageUrl = baseBean.nextPageUrl
        if (isRefresh) {
            multiItemAdapter?.setRefreshData(baseBean.itemList)
        } else {
            multiItemAdapter?.setLoadMore(baseBean.itemList)
        }
    }

    override fun showLoading() {
        loadingProgressBar.show()
    }

    override fun hideLoading() {
        loadingProgressBar.hide()
    }

    override fun showMessage(message: String) {
        stopRefresh()
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    private fun stopRefresh() {
        refreshLayout.finishRefresh()
        refreshLayout.finishLoadMore()
    }
}