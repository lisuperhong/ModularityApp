package com.lisuperhong.openeye.ui.fragment.home

import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.company.commonbusiness.base.fragment.BaseMvpFragment

import com.lisuperhong.openeye.R
import com.lisuperhong.openeye.mvp.contract.DiscoveryContract
import com.lisuperhong.openeye.mvp.model.bean.BaseBean
import com.lisuperhong.openeye.mvp.presenter.DiscoveryPresenter
import com.lisuperhong.openeye.ui.adapter.MultiItemAdapter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import kotlinx.android.synthetic.main.fragment_discovery.*

/**
 * A simple [Fragment] subclass.
 *
 */
class DiscoveryFragment : BaseMvpFragment<DiscoveryPresenter>(), DiscoveryContract.View {

    private var multiItemAdapter: MultiItemAdapter? = null

    private var isRefresh = false

    override val layoutId: Int
        get() = R.layout.fragment_discovery

    override fun setPresenter() {
        presenter = DiscoveryPresenter(this)
    }

    override fun initView() {
        refreshLayout.setEnableLoadMore(false)
        refreshLayout.setRefreshHeader(ClassicsHeader(activity))
        refreshLayout.setOnLoadMoreListener {
            isRefresh = true
            initData()
        }

        multiItemAdapter = MultiItemAdapter(getContext()!!, ArrayList<BaseBean.Item>())
        discoveryRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        discoveryRecycleView.adapter = multiItemAdapter
        isRefresh = false
        showLoading()
    }

    override fun initData() {
        presenter?.discovery()
    }

    override fun showContent(baseBean: BaseBean) {
        stopRefresh()
        if (baseBean.itemList.isEmpty())
            return
        if (isRefresh) {
            multiItemAdapter?.setRefreshData(baseBean.itemList)
        } else {
            multiItemAdapter?.setLoadMore(baseBean.itemList)
        }
    }

    override fun showMessage(message: String) {
        stopRefresh()
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        loadingProgressBar.show()
    }

    override fun hideLoading() {
        loadingProgressBar.hide()
    }

    private fun stopRefresh() {
        refreshLayout.finishRefresh()
        refreshLayout.finishLoadMore()
    }
}
