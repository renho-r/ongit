package com.renho.springbootcode.util;

/**
 * @author renho
 * @date 2020/11/24
 */
public class LogUtil {

    public final static String PRE = "========================> ";
    public final static String SUF = " <========================";

    public static void mark(Object mark) {
        System.out.println(PRE + mark + SUF);
    }

    public static void mark() {
        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
        StackTraceElement ste = stackTrace[1];
        mark(ste.getClassName() + "." + ste.getMethodName());
    }

}
