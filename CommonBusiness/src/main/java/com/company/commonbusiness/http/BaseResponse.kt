package com.company.commonbusiness.http

/**
 * Author: 李昭鸿
 * Time: Create on 2019/2/21 17:58
 * Desc: 接口返回数据格式基类
 */

class BaseResponse<T>(val code: Int, val message: String, val content: T) {

    val isSuccess: Boolean get() = code == 0
}