package com.company.commonbusiness.base.activity

import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

import com.company.commonbusiness.util.ActivityUtils
import com.orhanobut.logger.Logger

/**
 * @author 李昭鸿
 * @desc: Activity基类
 * @date Created on 2017/7/21 10:27
 */

abstract class BaseActivity : AppCompatActivity() {

    protected val TAG = this.javaClass.simpleName

    @get:LayoutRes
    protected abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.d("onCreate Invoke...")
        ActivityUtils.addActivity(this)
        setContentView(layoutId)

        if (null != intent) {
            handleIntent(intent)
        }

        initPresenter()
        initView()
        initData(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.d("onDestroy Invoke...")
        ActivityUtils.removeActivity(this)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Logger.d("onLowMemory Invoke...")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Logger.d("onBackPressed Invoke...")
    }

    /**
     * 处理跳转时传递的数据
     * @param intent
     */
    open fun handleIntent(intent: Intent) {

    }

    /**
     * 如果Activity是使用MVP，初始化presenter
     */
    open fun initPresenter() {

    }

    protected fun setToolBar(toolbar: Toolbar, title: String) {
        toolbar.title = title
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    /**
     * 通过Class跳转界面
     */
    protected fun startActivity(cls: Class<*>) {
        startAcvitity(cls, null)
    }

    protected fun startAcvitity(cls: Class<*>, bundle: Bundle? = null) {
        val intent = Intent(this, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    protected fun startActivityForResult(cls: Class<*>, requestCode: Int) {
        startActivityForResult(cls, null, requestCode)
    }

    protected fun startActivityForResult(cls: Class<*>, bundle: Bundle? = null, requestCode: Int) {
        val intent = Intent(this, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivityForResult(intent, requestCode)
    }

    /**
     * 初始化View
     */
    protected abstract fun initView()

    /**
     * 初始化数据，从服务端或本地加载数据
     */
    protected abstract fun initData(savedInstanceState: Bundle?)
}
