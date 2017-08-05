package com.company.commonbusiness.http;

/**
 * @author 李昭鸿
 * @desc:
 * @date Created on 2017/7/28 11:15
 */

public class ServerException extends Throwable {

    private int code;

    public ServerException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
