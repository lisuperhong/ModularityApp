package com.company.commonbusiness.http

import java.io.Serializable

/**
 * @author 李昭鸿
 * @desc: 处理服务器统一返回数据
 * @date Created on 2017/7/26 16:51
 */

class BaseResponse<T>(val code: Int, val message: String, val content: T) : Serializable {

    val isSuccess: Boolean get() = code == 0
}