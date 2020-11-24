package com.renho.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class TreeMapTest {

    public static void main(String[] args) {

        Map<MyKey, Integer> map = new TreeMap<>();
        for (int i=0; i<10; i++) {
            map.put(new MyKey(i), i);
        }

        System.out.printf("done\n");

    }

}
