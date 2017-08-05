package com.company.commonbusiness.base.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.commonbusiness.base.activity.BaseActivity;
import com.company.commonbusiness.log.XLog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author 李昭鸿
 * @desc: Fragment基类
 * @date Created on 2017/7/21 15:35
 */

public abstract class BaseFragment extends Fragment {

    protected final String TAG = this.getClass().getSimpleName();

    protected BaseActivity activity;
    private Unbinder unbinder;

    //获取宿主Activity
    protected BaseActivity getHoldingActivity() {
        return activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        XLog.d(TAG, "onAttach Invoke...");
        this.activity = (BaseActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XLog.d(TAG, "onCreate Invoke...");
        if (null != getArguments()) {
            handleArguments();
        }
    }

    /**
     * 处理跳转时传递的数据
     */
    protected void handleArguments() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        XLog.d(TAG, "onCreateView Invoke...");
        View view = inflater.inflate(getLayoutResId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        XLog.d(TAG, "onActivityCreated Invoke...");
        initView();
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        XLog.d(TAG, "onDestroyView Invoke...");
        unbinder.unbind();
    }

    //获取布局文件ID
    protected abstract int getLayoutResId();

    public abstract int initView();

    public abstract int initData();
}
