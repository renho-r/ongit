package com.renho.solution;

/**
 * @author renho
 * @date 2021/6/30
 */
public class P1553 {

    public static void main(String[] args) {
        P1553 p1553 = new P1553();
        System.out.println(p1553.minDays(1));
        System.out.println(p1553.minDays(2));
        System.out.println(p1553.minDays(3));
        System.out.println(p1553.minDays(4));
        System.out.println(p1553.minDays(5));
        System.out.println(p1553.minDays(6));
        System.out.println(p1553.minDays(7));
    }

    public int minDays(int n) {
        int[] cache = new int[n + 1];
        for(int i=1; i<=n; i++) {
            int f = cache[i - 1];//3
            int s = Integer.MAX_VALUE;
            if (0 == i%2) {
                s = cache[i/2];
            }
            int t = Integer.MAX_VALUE;
            if(0 == i%3) {
                t = cache[i - 2*(i/3)];
            }
            int min = Math.min(Math.min(f, s), t) + 1;
            cache[i] = min;
        }
        return cache[n];
    }
}
