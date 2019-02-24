package com.company.commonbusiness.util

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.os.Build
import android.util.ArrayMap


import com.company.commonbusiness.base.activity.BaseActivity

import java.lang.reflect.Field
import java.util.ArrayList
import java.util.HashMap

/**
 * @author 李昭鸿
 * @desc: Activity相关工具类
 * @date Created on 2017/7/21 17:14
 */

class ActivityUtils private constructor() {

    init {
//        throw UnsupportedOperationException("u can't instantiate me...")
    }

    companion object {

        private val activities = ArrayList<BaseActivity>()

        /**
         * 添加Activity到列表
         *
         * @param activity 添加的activity
         */
        fun addActivity(activity: BaseActivity) {
            activities.add(activity)
        }

        /**
         * 从列表中移除Activity
         *
         * @param activity 移除的activity
         */
        fun removeActivity(activity: BaseActivity) {
            activities.remove(activity)
        }

        /**
         * 用于退出app时结束所有Activity
         */
        fun finishAll() {
            for (activity in activities) {
                if (!activity.isFinishing) {
                    activity.finish()
                }
            }
        }

        /**
         * 判断是否存在Activity
         *
         * @param packageName 包名
         * @param className   activity全路径类名
         * @return `true`: 是<br></br>`false`: 否
         */
        fun isActivityExists(packageName: String, className: String): Boolean {
            val intent = Intent()
            intent.setClassName(packageName, className)
            return !(Utils.getContext().packageManager.resolveActivity(intent, 0) == null ||
                    intent.resolveActivity(Utils.getContext().packageManager) == null ||
                    Utils.getContext().packageManager.queryIntentActivities(intent, 0).size == 0)
        }

        /**
         * 获取launcher activity
         *
         * @param packageName 包名
         * @return launcher activity
         */
        fun getLauncherActivity(packageName: String): String {
            val intent = Intent(Intent.ACTION_MAIN, null)
            intent.addCategory(Intent.CATEGORY_LAUNCHER)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            val pm = Utils.getContext().packageManager
            val info = pm.queryIntentActivities(intent, 0)
            for (aInfo in info) {
                if (aInfo.activityInfo.packageName == packageName) {
                    return aInfo.activityInfo.name
                }
            }
            return "no $packageName"
        }

        /**
         * 获取栈顶Activity
         *
         * @return 栈顶Activity
         */
//        val topActivity: Activity?
//            get() {
//                try {
//                    val activityThreadClass = Class.forName("android.app.ActivityThread")
//                    val activityThread =
//                        activityThreadClass.getMethod("currentActivityThread").invoke(null)
//                    val activitiesField = activityThreadClass.getDeclaredField("mActivities")
//                    activitiesField.isAccessible = true
//                    val activities: Map<*, *>
//                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
//                        activities = activitiesField.get(activityThread) as HashMap<*, *>
//                    } else {
//                        activities = activitiesField.get(activityThread) as ArrayMap<*, *>
//                    }
//                    for (activityRecord in activities.values) {
//                        val activityRecordClass = activityRecord.javaClass
//                        val pausedField = activityRecordClass.getDeclaredField("paused")
//                        pausedField.isAccessible = true
//                        if (!pausedField.getBoolean(activityRecord)) {
//                            val activityField = activityRecordClass.getDeclaredField("activity")
//                            activityField.isAccessible = true
//                            return activityField.get(activityRecord) as Activity
//                        }
//                    }
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                }
//
//                return null
//            }
    }
}
