package com.renho.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Client {

    public static void main(String[] args) {

        Map<Integer, Object> hashTable = new Hashtable<>();
        for (int i=0; i<20; i++) {
            hashTable.put(i, i);
        }
        System.out.printf("size: %s\n", hashTable.size());
        System.out.printf("%d\n", -5%2);
        System.out.printf("%d\n", -5&Integer.MAX_VALUE%2);

        Map<Integer, Object> hashMap = new HashMap<>();
        for (int i=0; i<20; i++) {
            hashMap.put(i, i);
        }
        System.out.printf("size: %s\n", hashMap.size());

        Map<Integer, Object> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i=0; i<20; i++) {
            concurrentHashMap.put(i, i);
        }
        System.out.printf("size: %s\n", concurrentHashMap.size());
    }

}
