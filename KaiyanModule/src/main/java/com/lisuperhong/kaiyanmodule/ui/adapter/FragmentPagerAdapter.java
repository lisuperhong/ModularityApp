package com.lisuperhong.kaiyanmodule.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.company.commonbusiness.base.fragment.BaseFragment;

import java.util.List;

/**
 * @author 李昭鸿
 * @desc:
 * @date Created on 2017/10/17 16:15
 */

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> fragments;
    private String[] tabTitles;

    public FragmentPagerAdapter(FragmentManager fragmentManager, List<BaseFragment> fragments, String[] tabTitles) {
        super(fragmentManager);
        this.fragments = fragments;
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments != null && fragments.size() > position) {
            return fragments.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
