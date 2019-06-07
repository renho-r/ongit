package com.renho;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class LouTi {

    public static void main(String[] args) {
        System.out.println(getWay(3));
    }

    private static int getWay(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int s1 = 1;
        int s2 = 2;
        int temp = 0;
        for(int i=3; i<=n; i++) {
            temp = s1 + s2;
            s1 = s2;
            s2 = temp;
        }
        return temp;
    }

}
