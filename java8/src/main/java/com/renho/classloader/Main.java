package com.renho.classloader;

import java.io.IOException;

/**
 * @author renho
 * @since: 2020/6/16
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("start");
        Singleton.getInstance();
        System.out.println("load ok");
        System.in.read();
    }

}
