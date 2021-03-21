package com.renho.groovy.demo;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author renho
 * @date 2021/2/5
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (;;) {
            executor.execute(Client::execGroovy);
            TimeUnit.MILLISECONDS.sleep(10L);
        }
    }

    private static void execGroovy() {
        GroovyClassLoader classLoader = new GroovyClassLoader();
        Class groovyClass = classLoader.parseClass("def cal(int a, int b){\n" +
                "    return a+b\n" +
                "}");
        try {
            Object[] param = {8, 7};
            GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
            Object result = groovyObject.invokeMethod("cal", param);
            System.out.println(Thread.currentThread().getName() + ": " + result);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
