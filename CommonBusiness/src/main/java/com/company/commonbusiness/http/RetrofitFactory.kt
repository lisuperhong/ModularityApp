package com.company.commonbusiness.http

import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit

import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author 李昭鸿
 * @desc: Retrofit配置类
 * @date Created on 2017/7/26 16:31
 */

class RetrofitFactory private constructor() {

    private val isTrustAll = true
    private val builder: Retrofit.Builder

    init {
        builder = Retrofit.Builder()
            .client(setOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
    }

    /**
     * 配置OkHttp
     *
     * @return 自定义的OkHttp
     */
    fun setOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
            .connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)

        // 设置https信任所有的证书
        if (isTrustAll) {
            val trustManager = object : X509TrustManager {
                @Throws(CertificateException::class)
                override fun checkClientTrusted(
                    x509Certificates: Array<X509Certificate>,
                    s: String
                ) {

                }

                @Throws(CertificateException::class)
                override fun checkServerTrusted(
                    x509Certificates: Array<X509Certificate>,
                    s: String
                ) {

                }

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
            }

            try {
                val sslContext = SSLContext.getInstance("TLS")
                sslContext.init(null, arrayOf<TrustManager>(trustManager), null)
                val sslSocketFactory = sslContext.socketFactory
                builder.sslSocketFactory(sslSocketFactory, trustManager)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        return builder.build()
    }

    /**
     * 返回接口Service
     *
     * @param service 接口服务
     * @param <T> 泛型
     * @return
    </T> */
    fun <T> initService(service: Class<T>?, hostUrl: String): T {
        if (service == null) {
            throw RuntimeException("Api service is null!")
        }

        val retrofit = builder.baseUrl(hostUrl).build()

        return retrofit.create(service)
    }

    companion object {

        private val DEFAULT_TIMEOUT = 20
        private var instance: RetrofitFactory? = null

        fun getInstance(): RetrofitFactory {
            if (null == instance) {
                synchronized(RetrofitFactory::class.java) {
                    if (null == instance) {
                        instance = RetrofitFactory()
                    }
                }
            }

            return instance!!
        }
    }

}
