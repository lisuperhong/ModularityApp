package com.company.commonbusiness.http.rx;

import com.company.commonbusiness.http.ResponseEntity;
import com.company.commonbusiness.http.ServerException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 李昭鸿
 * @desc: Rxjava帮助类
 * @date Created on 2017/7/28 10:49
 */

public class RxHelper {

    /**
     * 对服务器返回数据作统一转换，根据code处理实体数据或者发送异常到观察者
     *
     * @param <T> 数据实体类
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<ResponseEntity<T>, T> handleNetworkResult() {
        return new ObservableTransformer<ResponseEntity<T>, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<ResponseEntity<T>> upstream) {
                return upstream.flatMap(new Function<ResponseEntity<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(@NonNull ResponseEntity<T> result) throws Exception {
                        if (result.isSuccess()) {
                            return createData(result.getContent());
                        } else {
                            return Observable.error(new ServerException(result.getCode(), result.getMessage()));
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 发送实体数据到downstream
     *
     * @param data content实体类
     * @param <T> 数据实体类
     * @return 观察者
     */
    private static <T> Observable<T> createData(final T data) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(data);
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
    }

    /**
     * 处理线程调度的变换
     *
     * @return 线程转换Transformer
     */
    public static ObservableTransformer handleSchedulers() {
        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(@NonNull Observable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
