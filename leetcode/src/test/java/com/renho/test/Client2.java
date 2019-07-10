package com.renho.test;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Client2 {

    @Test
    public void forFb() {
        int[] result = new int[20];
        for (int i=0; i<result.length; i++) {
            if (0==i || 1==i) {
                result[i] = 1;
                continue;
            }
            result[i] = result[i-1] + result[i-2];
        }
        Arrays.stream(result).forEach(System.out::println);
    }

    @Test
    public void recursionFb() {
//        System.out.println(fb(6));
        fb(50);
    }

    private int count = 1;
    private Map<Integer, Integer> map = new HashMap<>();

    private int fb(int index) {
        System.out.println(count++);
        if (0==index || 1==index) {
            return 1;
        }
//        int result = fb(index - 1) + fb(index - 2);
        int result = (null!=map.get(index-1)? map.get(index-1): fb(index - 1)) + (null!=map.get(index-2)? map.get(index-2): fb(index - 2));
//        int result = null!=map.get(index)? map.get(index): fb(index - 1) + fb(index - 2);
        map.put(index, result);
        return result;
    }

}
