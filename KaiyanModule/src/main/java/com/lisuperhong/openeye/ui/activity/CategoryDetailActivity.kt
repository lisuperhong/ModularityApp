package com.lisuperhong.openeye.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.company.commonbusiness.base.activity.BaseMvpActivity
import com.lisuperhong.openeye.R
import com.lisuperhong.openeye.mvp.contract.CategoryDetailContract
import com.lisuperhong.openeye.mvp.model.bean.BaseBean
import com.lisuperhong.openeye.mvp.model.bean.CategoryTabInfo
import com.lisuperhong.openeye.mvp.presenter.CategoryDetailPresenter
import com.lisuperhong.openeye.ui.adapter.MultiItemAdapter
import com.lisuperhong.openeye.utils.Constant
import com.lisuperhong.openeye.utils.ImageLoad
import com.lisuperhong.openeye.utils.TypefaceUtil
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import kotlinx.android.synthetic.main.activity_category_detail.*

class CategoryDetailActivity : BaseMvpActivity<CategoryDetailPresenter>(), CategoryDetailContract.View {

    private var categoryName: String? = null
    private var categoryId: Long = 0
    private var multiItemAdapter: MultiItemAdapter? = null
    private var isRefresh = false
    private var nextPageUrl: String? = null

    override val layoutId: Int
        get() = R.layout.activity_category_detail

    override fun setPresenter() {
        presenter = CategoryDetailPresenter(this)
    }

    override fun initView() {
        appBarLayout.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (Math.abs(verticalOffset) >= appBarLayout!!.totalScrollRange) { // 收缩状态
                toolbar.setNavigationIcon(R.drawable.ic_action_back)
                toolbarTitleTv.text = categoryName
            } else { // 展开或过度状态
                toolbar.setNavigationIcon(R.drawable.ic_action_back_white)
                toolbarTitleTv.text = ""
            }
        }

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        refreshLayout.setRefreshHeader(ClassicsHeader(this))
        refreshLayout.setEnableAutoLoadMore(true)
        refreshLayout.setOnRefreshListener {
            isRefresh = true
            presenter?.getVideoList(categoryId)
        }

        refreshLayout.setOnLoadMoreListener {
            isRefresh = false
            if (nextPageUrl != null) {
                presenter?.loadMore(nextPageUrl!!)
            } else {
                refreshLayout.setEnableLoadMore(false)
            }
        }

        multiItemAdapter = MultiItemAdapter(this, ArrayList<BaseBean.Item>())
        categoryDetailRecycleView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        categoryDetailRecycleView.adapter = multiItemAdapter
        isRefresh = false
        showLoading()
    }

    override fun initData(savedInstanceState: Bundle?) {
        categoryId = intent.getLongExtra(Constant.INTENT_CATEGORY_ID, 0)
        presenter?.getCategoryInfo(categoryId)
    }

    override fun showCategoryInfo(categoryTabInfo: CategoryTabInfo) {
        toolbar.title = ""
        categoryName = categoryTabInfo.categoryInfo.name
        categoryNameTv.typeface = TypefaceUtil.getTypefaceFromAsset(TypefaceUtil.FZLanTingCuHei)
        categoryNameTv.text = categoryName
        categoryTitleTv.text = categoryTabInfo.categoryInfo.description
        ImageLoad.loadImage(categoryDetailIv, categoryTabInfo.categoryInfo.headerImage)
        presenter?.getVideoList(categoryId)
    }

    override fun showVideoList(baseBean: BaseBean) {
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
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun stopRefresh() {
        refreshLayout.finishRefresh()
        refreshLayout.finishLoadMore()
    }
}
