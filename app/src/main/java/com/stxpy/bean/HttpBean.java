package com.stxpy.bean;

/**
 * Created by Administrator on 2017/1/18.
 */

public class HttpBean<T> {
    private String msg;
    private T data;
    private int status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
