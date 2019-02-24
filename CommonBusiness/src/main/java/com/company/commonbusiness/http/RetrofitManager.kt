package com.company.commonbusiness.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Author: 李昭鸿
 * Time: Create on 2019/2/22 14:58
 * Desc: Retrofit管理类
 */
class RetrofitManager private constructor() {

    private val builder: Retrofit.Builder
    private val clientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

    companion object {
        private const val DEFAULT_TIMEOUT: Long = 60L
        val instance: RetrofitManager by lazy { RetrofitManager() }
    }

    init {
        builder = Retrofit.Builder()
            .client(defaultClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
    }

    private fun defaultClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        clientBuilder.addInterceptor(httpLoggingInterceptor)
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)

        return clientBuilder.build()
    }

    fun getClientBuilder(): OkHttpClient.Builder {
        return clientBuilder
    }

    /**
     * 自定义OkHttp客户端
     *
     * @param okHttpClient
     */
    fun customClient(okHttpClient: OkHttpClient) {
        builder.client(okHttpClient)
    }

    /**
     * 返回模块定义的Retrofit
     *
     * @param hostUrl 服务器接口主机地址
     * @return 对应的Retrofit实例
     */
    fun moduleRetrofit(hostUrl: String): Retrofit {
        return builder.baseUrl(hostUrl).build()
    }

    /**
     * 返回模块定义的接口Service
     * @param service 接口服务
     * @param hostUrl 服务器接口主机地址
     * @return <T> service实例
     */
    fun <T> initModuleService(service: Class<T>?, hostUrl: String): T {
        if (service == null) {
            throw RuntimeException("Api service is null!")
        }

        val retrofit = builder.baseUrl(hostUrl).build()
        return retrofit.create(service)
    }
 }