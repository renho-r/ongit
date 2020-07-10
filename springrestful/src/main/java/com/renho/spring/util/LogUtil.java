package com.renho.spring.util;

public class LogUtil {

    public static void logStack() {
        StackTraceElement[] stes = Thread.currentThread().getStackTrace();
        System.out.println(stes[2].getClassName() + ": " + stes[2].getMethodName());
    }

}
