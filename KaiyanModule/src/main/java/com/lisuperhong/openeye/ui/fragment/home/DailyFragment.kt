package com.lisuperhong.openeye.ui.fragment.home

import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.company.commonbusiness.base.fragment.BaseMvpFragment

import com.lisuperhong.openeye.R
import com.lisuperhong.openeye.mvp.contract.DailyContract
import com.lisuperhong.openeye.mvp.model.bean.BaseBean
import com.lisuperhong.openeye.mvp.presenter.DailyPresenter
import com.lisuperhong.openeye.ui.adapter.MultiItemAdapter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import kotlinx.android.synthetic.main.fragment_daily.*

/**
 * A simple [Fragment] subclass.
 *
 */
class DailyFragment : BaseMvpFragment<DailyPresenter>(), DailyContract.View {

    private var multiItemAdapter: MultiItemAdapter? = null
    private var isRefresh = false
    private var nextPageUrl: String? = null

    override val layoutId: Int
        get() = R.layout.fragment_daily

    override fun setPresenter() {
        presenter = DailyPresenter(this)
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
                presenter?.feedLoadMore(nextPageUrl!!)
            } else {
                refreshLayout.setEnableLoadMore(false)
            }
        }

        multiItemAdapter = MultiItemAdapter(getContext()!!, ArrayList<BaseBean.Item>())
        dailyRecycleView.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        dailyRecycleView.adapter = multiItemAdapter
        isRefresh = false
        showLoading()
    }

    override fun initData() {
        presenter?.feed(System.currentTimeMillis(), 2)
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
