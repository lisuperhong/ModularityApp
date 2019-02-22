package com.company.commonbusiness.http.rx

import com.company.commonbusiness.http.BaseResponse
import com.company.commonbusiness.http.ServerException

import io.reactivex.Observable
import io.reactivex.ObservableTransformer

/**
 * @author 李昭鸿
 * @desc: Rxjava帮助类
 * @date Created on 2017/7/28 10:49
 */

object RxHelper {

    /**
     * 对服务器返回数据作统一转换，根据code处理实体数据或者发送异常到观察者
     *
     * @param <T> 数据实体类
     * @return ObservableTransformer
    </T> */
    fun <T> handleNetworkRespose(): ObservableTransformer<BaseResponse<T>, T> {
        return ObservableTransformer { upstream ->
            upstream.flatMap { result ->
                if (result.isSuccess) {
                    createData(result.content)
                } else {
                    Observable.error(ServerException(result.code, result.message))
                }
            }
        }
    }

    /**
     * 发送实体数据到downstream
     *
     * @param data content实体类
     * @param <T> 数据实体类
     * @return 观察者
    </T> */
    private fun <T> createData(data: T): Observable<T> {
        return Observable.create { emitter ->
            try {
                emitter.onNext(data)
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }
    }
}
