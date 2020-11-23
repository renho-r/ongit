package com.renho.lock;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.io.IOException;

/**
 * @author renho
 * @since: 2020/6/22
 */
public class Synchronized {

    private int i = 100;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(Thread.currentThread().getId());
        //查看对象内部信息
        Synchronized testObjectSize = new Synchronized();
        System.out.println(ClassLayout.parseInstance(testObjectSize).toPrintable());
        System.out.println("=================");
        synchronized (testObjectSize){
            System.out.println(ClassLayout.parseInstance(testObjectSize).toPrintable());
        }
        System.out.println("=================");

        System.out.println(GraphLayout.parseInstance(testObjectSize).toPrintable());
        System.out.println("=================");
        System.out.println(GraphLayout.parseInstance(testObjectSize).totalSize());

        System.out.println(ClassLayout.parseInstance(new Object[0]).toPrintable());
    }

}
