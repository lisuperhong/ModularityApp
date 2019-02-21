package com.company.commonbusiness.base

import android.content.Context
import android.content.Intent
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication

import com.alibaba.android.arouter.launcher.ARouter
import com.company.commonbusiness.util.Utils
import com.crland.wuye.commonbusiness.BuildConfig
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * @author 李昭鸿
 * @desc: Application基类，主要做各种初始化工作，主app和各module都应继承该基类
 * @date Created on 2017/8/5 16:57
 * @github: https://github.com/lisuperhong
 */

open class BaseApplication : MultiDexApplication() {

    companion object {

        // 以下属性应用于整个应用程序，合理利用资源，减少资源浪费
        private var context: Context? = null //上下文
        var instance: BaseApplication? = null
            private set
    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        context = applicationContext

        // 初始化ARouter
        if (BuildConfig.DEBUG) {
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化

        // 初始化Logger
        Logger.addLogAdapter(AndroidLogAdapter())

        // 初始化工具类
        Utils.init(this)
    }

    /**
     * 重启当前应用
     */
    fun restart() {
        val intent = context!!.packageManager.getLaunchIntentForPackage(context!!.packageName)
        intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context!!.startActivity(intent)
    }

    fun getContext(): Context? {
        return context
    }
}
