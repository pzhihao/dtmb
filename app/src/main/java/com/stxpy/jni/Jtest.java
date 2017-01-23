package com.stxpy.jni;

/**
 * Created by Administrator on 2017/1/20.
 */

public class Jtest  {
    static {
        System.loadLibrary("mylib");
    }
    public native void sayHello();
}
