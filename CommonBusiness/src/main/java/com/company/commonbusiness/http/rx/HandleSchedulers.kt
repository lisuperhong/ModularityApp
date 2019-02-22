package com.company.commonbusiness.http.rx

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Author: lizhaohong
 * Time: Create on 2019/2/22 10:13
 * Desc: 线程调度器
 */

/**
 * IO线程到UI主线程调度器
 */
class IoMainScheduler<T> : BaseScheduler<T>(Schedulers.io(), AndroidSchedulers.mainThread())

/**
 * 新开线程到UI主线程调度器
 */
class NewThreadMainScheduler<T> : BaseScheduler<T>(Schedulers.newThread(), AndroidSchedulers.mainThread())

/**
 * 大数据量计算线程到UI线程调度器
 */
class ComputationMainScheduler<T> : BaseScheduler<T>(Schedulers.computation(), AndroidSchedulers.mainThread())