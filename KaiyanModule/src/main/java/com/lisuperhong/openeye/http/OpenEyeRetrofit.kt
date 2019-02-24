package com.lisuperhong.openeye.http

import com.company.commonbusiness.http.RetrofitManager
import com.lisuperhong.openeye.OpenEyeApplication
import com.lisuperhong.openeye.utils.CommonUtil
import com.lisuperhong.openeye.utils.Constant
import com.lisuperhong.openeye.utils.NetworkUtil
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit

class OpenEyeRetrofit private constructor() {

    private val retrofit: Retrofit

    init {
        val builder: OkHttpClient.Builder = RetrofitManager.instance.getClientBuilder()
        builder.addInterceptor(addQueryParameterInterceptor())
        RetrofitManager.instance.customClient(builder.build())
        retrofit = RetrofitManager.instance.moduleRetrofit(Constant.HOST)
    }

    companion object {
        val INSTANCE: OpenEyeRetrofit by lazy { OpenEyeRetrofit() }
    }

    /**
     * 返回模块定义的接口Service
     * @param service 接口服务
     * @return <T> service实例
     */
    fun <T> initService(service: Class<T>?): T {
        if (service == null) {
            throw RuntimeException("Api service is null!")
        }

        return retrofit.create(service)
    }

    /**
     * 设置公共参数
     */
    private fun addQueryParameterInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val request: Request
            val modifiedUrl = originalRequest.url().newBuilder()
                .addQueryParameter("udid", "525fe2e3c24149e69947443589b7a9b137a01aaf")
                .addQueryParameter("vc", "403")
                .addQueryParameter("vn", CommonUtil.getVersionName())
                .addQueryParameter("deviceModel", CommonUtil.getDeviceModel())
                .addQueryParameter("first_channel", "eyepetizer_zhihuiyun_market")
                .addQueryParameter("last_channel", "eyepetizer_zhihuiyun_market")
                .addQueryParameter("system_version_code", CommonUtil.getSystemVersion().toString())
                .build()
            request = originalRequest.newBuilder().url(modifiedUrl).build()
            chain.proceed(request)
        }
    }

    /**
     * 设置缓存
     */
//    private fun addCacheInterceptor(): Interceptor {
//        return Interceptor { chain ->
//            var request = chain.request()
//            if (!NetworkUtil.isNetworkAvailable(OpenEyeApplication.context)) {
//                request = request.newBuilder()
//                    .cacheControl(CacheControl.FORCE_CACHE)
//                    .build()
//            }
//            val response = chain.proceed(request)
//            if (NetworkUtil.isNetworkAvailable(OpenEyeApplication.context)) {
//                val maxAge = 0
//                // 有网络时 设置缓存超时时间0个小时 ,意思就是不读取缓存数据,只对get有用,post没有缓冲
//                response.newBuilder()
//                    .header("Cache-Control", "public, max-age=" + maxAge)
//                    .removeHeader("Retrofit")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
//                    .build()
//            } else {
//                // 无网络时，设置超时为4周  只对get有用,post没有缓冲
//                val maxStale = 60 * 60 * 24 * 28
//                response.newBuilder()
//                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                    .removeHeader("nyn")
//                    .build()
//            }
//            response
//        }
//    }
}