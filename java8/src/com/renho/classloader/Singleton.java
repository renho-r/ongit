package com.renho.classloader;

/**
 * @author renho
 * @since: 2020/6/16
 */
public class Singleton {

    static {
        System.out.println("load ... ");
    }

    private Singleton() {}

    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}