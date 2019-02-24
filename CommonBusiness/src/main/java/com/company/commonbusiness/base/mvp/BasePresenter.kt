package com.company.commonbusiness.base.mvp

import android.app.Activity
import android.support.annotation.UiThread
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

import java.lang.ref.WeakReference

/**
 * @author 李昭鸿
 * @desc: Presenter基类，统一完成view的绑定、解绑以及订阅取消
 * @date Created on 2017/7/21 10:22
 */

open class BasePresenter<V : IMvpView> constructor(rootView: V) : IMvpPresenter {

    private var viewRef: WeakReference<V>? = null
    private var compositeDisposable: CompositeDisposable? = null
    protected var rootView: V? = null

    init {
        this.rootView = rootView
    }

    private val view: V?
        @UiThread
        get() = if (viewRef == null) null else viewRef!!.get()

    private val isViewAttached: Boolean
        @UiThread
        get() = view != null

    @UiThread
    override fun attachView() {
        viewRef = WeakReference(rootView!!)
    }

    @UiThread
    override fun detachView() {
        if (viewRef != null) {
            viewRef!!.clear()
            viewRef = null
            removeDispose()
        }
    }
    /**
     * 将 [Disposable] 添加到 [CompositeDisposable] 中统一管理
     * 可在 [Activity.onDestroy] 中使用 [.removeDispose] 停止正在执行的 RxJava 任务，避免内存泄漏(框架已自行处理)
     *
     * @param disposable
     */
    fun addDispose(disposable: Disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable!!.add(disposable)
    }

    /**
     * 停止集合中正在执行的 RxJava 任务
     */
    private fun removeDispose() {
        if (compositeDisposable != null) {
            compositeDisposable!!.clear()
        }
    }

    /**
     * 检查是否已经绑定view，没绑定统一抛出异常
     */
    fun checkViewAttached() {
        if (!isViewAttached)
            throw MvpViewNotAttachedException()
    }

    private class MvpViewNotAttachedException internal constructor() :
        RuntimeException("Please call IMvpPresenter.attachView(IMvpView) before" + " requesting data to the IMvpPresenter")
}
