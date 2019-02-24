package com.lisuperhong.openeye.ui.fragment.rank


import android.graphics.Typeface
import android.widget.Toast
import com.company.commonbusiness.base.BaseApplication
import com.company.commonbusiness.base.adapter.BaseFragmentAdapter
import com.company.commonbusiness.base.fragment.BaseFragment
import com.company.commonbusiness.base.fragment.BaseMvpFragment
import com.lisuperhong.openeye.R
import com.lisuperhong.openeye.mvp.contract.TabInfoContract
import com.lisuperhong.openeye.mvp.model.bean.TabInfoBean
import com.lisuperhong.openeye.mvp.presenter.TabInfoPresenter
import kotlinx.android.synthetic.main.fragment_rank.*

class RankFragment : BaseMvpFragment<TabInfoPresenter>(), TabInfoContract.View {

    private val titleList = ArrayList<String>()
    private val fragmentList = ArrayList<BaseFragment>()

    override val layoutId: Int
        get() = R.layout.fragment_rank

    override fun setPresenter() {
        presenter = TabInfoPresenter(this)
    }

    override fun initView() {
        presenter?.getRankTabInfo()
    }

    override fun initData() {

    }

    override fun showTabInfo(tabInfoBean: TabInfoBean) {
        tabInfoBean.tabInfo.tabList.mapTo(titleList) { it.name }
        tabInfoBean.tabInfo.tabList.mapTo(fragmentList) { TabRankFragment.newInstance(it.apiUrl) }
        rankViewPager.adapter = BaseFragmentAdapter(childFragmentManager, fragmentList, titleList)
        rankViewPager.offscreenPageLimit = tabInfoBean.tabInfo.tabList.size - 1
        slidingTabLayout.setViewPager(rankViewPager)
        slidingTabLayout.currentTab = 0

        // 设置tab字体(不起作用?)
        val fontType =
            Typeface.createFromAsset(
                BaseApplication.context.assets,
                "fonts/FZLanTingHeiS-L-GB-Regular.TTF"
            )
        (0 until titleList.size)
            .forEach {
                slidingTabLayout.getTitleView(it).typeface = fontType
            }
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}
