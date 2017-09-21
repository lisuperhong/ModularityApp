package com.company.commonbusiness.http.rx;

import com.company.commonbusiness.http.ExceptionHandle;
import com.company.commonbusiness.log.XLog;
import com.orhanobut.logger.Logger;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author 李昭鸿
 * @desc: 观察者基类，统一处理数据及异常
 * @date Created on 2017/7/28 11:31
 */

public abstract class BaseObserver<T> implements Observer<T> {

    private Disposable disposable;

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        Logger.d("BaseObserver onSubscribe");
        disposable = d;
    }

    @Override
    public void onNext(@NonNull T t) {
        Logger.d("onNext：" + t.toString());
        success(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        error(ExceptionHandle.handleException(e).message);
    }

    @Override
    public void onComplete() {

    }

    public void dispose() {
        disposable.dispose();
    }

    protected abstract void success(T t);

    protected abstract void error(String errorMsg);
}
