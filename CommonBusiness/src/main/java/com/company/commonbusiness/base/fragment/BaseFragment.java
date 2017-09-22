package com.company.commonbusiness.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author 李昭鸿
 * @desc: Fragment基类
 * @date Created on 2017/7/21 15:35
 */

public abstract class BaseFragment extends Fragment {

    /**
     * 是否可见状态，为了避免和{@link android.support.v4.app.Fragment#isVisible()}冲突换个名字
     */
    private boolean isFragmentVisible;

    /**
     * 标志位，View已经初始化完成。
     */
    private boolean isPrepared;

    /**
     * 是否第一次加载
     */
    private boolean isFirstLoad = true;

    /**
     * <pre>
     * 忽略isFirstLoad的值，强制刷新数据，但仍要Visible & Prepared
     * 一般用于PagerAdapter需要刷新各个子Fragment的场景
     * 不要new新的PagerAdapter，而采取reset数据的方式
     * 所以要求Fragment重新走initData方法
     * 故使用 {@link BaseFragment#setForceLoad(boolean)}来让Fragment下次执行initData
     * </pre>
     */
    private boolean forceLoad = false;

    protected View rootView;
    protected Activity activity;
    protected Context context;
    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        Logger.d("onAttach Invoke...");
        activity = (Activity) context;
        this.context = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Logger.d("onCreateView Invoke...");
        if (getArguments() != null) {
            handleArguments();
        }

        rootView = inflater.inflate(getLayoutResId(), container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // 若viewpager不设置setOffscreenPageLimit或设置数量不够
        // 销毁的Fragment onCreateView 每次都会执行(但实体类没有从内存销毁)
        // onCreateView执行，证明被移出过FragmentManager initData确实要执行
        // 如果这里有数据累加的Bug，请在initView方法里初始化数据，比如 list.clear();
        super.onActivityCreated(savedInstanceState);
        Logger.d("onActivityCreated Invoke...");

        isFirstLoad = true;
        isPrepared = true;
        initView();
        lazyLoad();
    }

    /**
     * 处理跳转时传递的数据
     */
    protected void handleArguments() {

    }

    /**
     * 如果是与ViewPager一起使用，调用的是setUserVisibleHint
     *
     * @param isVisibleToUser Fragment是否显示
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            onVisible();
        } else {
            onInvisible();
        }
    }

    /**
     * 如果是通过FragmentTransaction的show和hide的方法来控制显示，调用的是onHiddenChanged.
     * 若是初始就show的Fragment 为了触发该事件 需要先hide再show
     *
     * @param hidden hidden True if the fragment is now hidden, false if it is not
     * visible.
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            onVisible();
        } else {
            onInvisible();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.d("onDestroyView Invoke...");
        isPrepared = false;
        unbinder.unbind();
    }

    protected void onVisible() {
        isFragmentVisible = true;
        lazyLoad();
    }

    protected void onInvisible() {
        isFragmentVisible = false;
    }

    /**
     * 要实现延迟加载Fragment内容，需要在 onCreateView
     * isPrepared = true;
     */
    protected void lazyLoad() {
        if (isPrepared() && isFragmentVisible()) {
            if (forceLoad || isFirstLoad()) {
                forceLoad = false;
                isFirstLoad = false;
                initData();
            }
        }
    }

    public boolean isPrepared() {
        return isPrepared;
    }

    /**
     * 忽略isFirstLoad的值，强制刷新数据，但仍要Visible & Prepared
     */
    public void setForceLoad(boolean forceLoad) {
        this.forceLoad = forceLoad;
    }

    public boolean isFirstLoad() {
        return isFirstLoad;
    }

    public boolean isFragmentVisible() {
        return isFragmentVisible;
    }

    //获取布局文件ID
    protected abstract int getLayoutResId();

    /**
     * 若把初始化内容放到initData实现
     * 就是采用Lazy方式加载的Fragment
     * 若不需要Lazy加载则initData方法内留空,初始化内容放到initView即可
     */
    protected abstract void initView();

    protected abstract void initData();
}
