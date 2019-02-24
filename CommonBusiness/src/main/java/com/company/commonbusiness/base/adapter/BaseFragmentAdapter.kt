package com.company.commonbusiness.base.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.company.commonbusiness.base.fragment.BaseFragment

/**
 * Author: lisuperhong
 * Time: Create on 2019/2/23 22:12
 * Github: https://github.com/lisuperhong
 * Desc: Fragment实例存在内存中，适用于页数数目少的情况
 */
class BaseFragmentAdapter(
    fm: FragmentManager,
    fragmentList: List<BaseFragment>,
    titles: List<String>
) : FragmentPagerAdapter(fm) {

    private var fragmentList: List<BaseFragment>? = null
    private var titles: List<String>? = null

    init {
        this.fragmentList = fragmentList
        this.titles = titles
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList!![position]
    }

    override fun getCount(): Int {
        return fragmentList?.size ?: 0
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles?.get(position) ?: ""
    }
}