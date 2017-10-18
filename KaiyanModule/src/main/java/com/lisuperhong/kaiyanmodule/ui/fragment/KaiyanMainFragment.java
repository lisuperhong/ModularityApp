package com.lisuperhong.kaiyanmodule.ui.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.company.commonbusiness.base.fragment.BaseFragment;
import com.lisuperhong.kaiyanmodule.R;
import com.lisuperhong.kaiyanmodule.R2;
import com.lisuperhong.kaiyanmodule.ui.adapter.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class KaiyanMainFragment extends BaseFragment {

    @BindView(R2.id.tbl_kaiyan_main)
    TabLayout tabLayout;
    @BindView(R2.id.viewPager_kaiyan_main)
    ViewPager viewPager;

	private String[] tabTitles = {"首页", "发现", "热门", "我的"};
	private FragmentPagerAdapter adapter;
	private List<BaseFragment> fragments;

	@Override
	protected int getLayoutResId() {
		return R.layout.kaiyan_fragment_main;
	}

	@Override
	protected void initView() {
		fragments = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			fragments.add(HomeFragment.newInstance(tabTitles[i]));
		}
		adapter = new FragmentPagerAdapter(getFragmentManager(), fragments, tabTitles);
		viewPager.setOffscreenPageLimit(4);
		viewPager.setAdapter(adapter);
		tabLayout.setupWithViewPager(viewPager);
	}

	@Override
	protected void initData() {

	}
}
