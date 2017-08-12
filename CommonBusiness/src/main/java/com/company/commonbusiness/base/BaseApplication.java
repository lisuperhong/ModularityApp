package com.company.commonbusiness.base;

import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author 李昭鸿
 * @desc: Application基类，主要做各种初始化工作，主app和各module都应继承该基类
 * @date Created on 2017/8/5 16:57
 * @github: https://github.com/lisuperhong
 */

public class BaseApplication extends MultiDexApplication {

    //以下属性应用于整个应用程序，合理利用资源，减少资源浪费
    private static Context context; //上下文
    private static BaseApplication instance;

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();

        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }

    /**
     * 重启当前应用
     */
    public void restart() {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public Context getContext() {
        return context;
    }
}
