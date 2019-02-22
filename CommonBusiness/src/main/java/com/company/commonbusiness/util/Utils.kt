package com.company.commonbusiness.util

import android.annotation.SuppressLint
import android.content.Context

/**
 * @author 李昭鸿
 * @desc: Utils初始化相关
 * @date Created on 2017/7/26 10:50
 */

class Utils private constructor() {

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }

    companion object {

        @SuppressLint("StaticFieldLeak")
        private var context: Context? = null

        /**
         * 初始化工具类
         *
         * @param context 上下文
         */
        fun init(context: Context) {
            Utils.context = context.applicationContext
        }

        /**
         * 获取ApplicationContext
         *
         * @return ApplicationContext
         */
        fun getContext(): Context {
            if (context != null) return context!!
            throw NullPointerException("u should init first")
        }
    }
}
