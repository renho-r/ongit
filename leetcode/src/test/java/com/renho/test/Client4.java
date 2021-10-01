package com.renho.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author renho
 * @date 2021/6/29
 */
public class Client4 {
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>(100);
        test.set(1, 100);
        System.out.println(test);

        LinkedList list = new LinkedList();
    }
}
