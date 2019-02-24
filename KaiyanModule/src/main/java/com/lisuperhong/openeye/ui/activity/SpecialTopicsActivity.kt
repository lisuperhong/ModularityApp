package com.lisuperhong.openeye.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.company.commonbusiness.base.activity.BaseMvpActivity
import com.lisuperhong.openeye.R
import com.lisuperhong.openeye.mvp.contract.SpecialTopicsContract
import com.lisuperhong.openeye.mvp.model.bean.BaseBean
import com.lisuperhong.openeye.mvp.presenter.SpecialTopicsPresenter
import com.lisuperhong.openeye.ui.adapter.MultiItemAdapter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import kotlinx.android.synthetic.main.activity_special_topics.*
import kotlinx.android.synthetic.main.custom_toolbar.*

class SpecialTopicsActivity : BaseMvpActivity<SpecialTopicsPresenter>(),
    SpecialTopicsContract.View {

    private var multiItemAdapter: MultiItemAdapter? = null

    override val layoutId: Int
        get() = R.layout.activity_special_topics

    override fun setPresenter() {
        presenter = SpecialTopicsPresenter(this)
    }

    override fun initView() {
        toolbarTitleTv.text = "专题"
        refreshLayout.setEnableLoadMore(false)
        refreshLayout.setRefreshHeader(ClassicsHeader(this))
        refreshLayout.setOnRefreshListener {
            presenter?.getSpecialTopics()
        }
        toolbarBackIv.setOnClickListener {
            onBackPressed()
        }

        multiItemAdapter = MultiItemAdapter(this, ArrayList<BaseBean.Item>())
        specialTopicsRecycleView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        specialTopicsRecycleView.adapter = multiItemAdapter
        showLoading()
    }

    override fun initData(savedInstanceState: Bundle?) {
        presenter?.getSpecialTopics()
    }

    override fun showSpecialTopics(bean: BaseBean) {
        refreshLayout.finishRefresh()
        if (bean.itemList.isEmpty())
            return

        multiItemAdapter?.setRefreshData(bean.itemList)
    }

    override fun showLoading() {
        loadingProgressBar.show()
    }

    override fun hideLoading() {
        loadingProgressBar.hide()
    }

    override fun showMessage(message: String) {
        refreshLayout.finishRefresh()
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
