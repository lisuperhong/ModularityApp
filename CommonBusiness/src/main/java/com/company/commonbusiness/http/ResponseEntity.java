package com.company.commonbusiness.http;

import java.io.Serializable;

/**
 * @author 李昭鸿
 * @desc: 处理服务器统一返回数据
 * @date Created on 2017/7/26 16:51
 */

public class ResponseEntity<T> implements Serializable {

    private int code;
    private String message;
    private T content;

    public boolean isSuccess() {
        return code == 0;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
