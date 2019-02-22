package com.company.commonbusiness.http

/**
 * @author 李昭鸿
 * @desc: 接口请求失败异常类型
 * @date Created on 2017/7/28 11:15
 */

class ServerException(val code: Int, message: String) : Throwable(message)
