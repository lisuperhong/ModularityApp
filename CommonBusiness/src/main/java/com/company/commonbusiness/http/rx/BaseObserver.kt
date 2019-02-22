package com.company.commonbusiness.http.rx

import com.company.commonbusiness.http.ExceptionHandle
import com.orhanobut.logger.Logger

import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

/**
 * @author 李昭鸿
 * @desc: 观察者基类，统一处理数据及异常
 * @date Created on 2017/7/28 11:31
 */

abstract class BaseObserver<T> : DisposableObserver<T>() {

    private var disposable: Disposable? = null

    override fun onNext(data: T) {
        Logger.d("BaseObserver onNext: " + data.toString())
        onSuccess(data)
    }

    override fun onComplete() {
        Logger.d("BaseObserver onComplete")
    }

    override fun onError(e: Throwable) {
        Logger.d("BaseObserver onError")
        onFailure(ExceptionHandle.handleException(e).msg ?: "未知错误")
    }

    abstract fun onSuccess(data: T)

    abstract fun onFailure(errorMsg: String)
}
