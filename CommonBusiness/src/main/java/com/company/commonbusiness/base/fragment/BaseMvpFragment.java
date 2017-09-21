package com.company.commonbusiness.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.company.commonbusiness.base.mvp.BasePresenter;
import com.company.commonbusiness.base.mvp.IMvpView;

/**
 * @author 李昭鸿
 * @desc: MVP模式的Fragment基类
 * @date Created on 2017/9/21 18:39
 */

public abstract class BaseMvpFragment<P extends BasePresenter> extends BaseFragment implements IMvpView {

	protected P presenter;

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		setPresenter();
		if (presenter != null) {
			presenter.attachView(this);
		}
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		if (presenter != null) {
			presenter.detachView();
		}
	}
}