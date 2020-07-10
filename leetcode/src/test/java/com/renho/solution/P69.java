package com.renho.solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P69 {

    @Test
    public void test() {
        int result = mySqrt(36);
        System.out.println(result);
    }

    public int mySqrt(int x) {
        if(0==x || 1==x) {
            return x;
        }
        double left = 0;
        double right = x;
        double mid = x;
        while (Math.abs(right-left) > 1e-1) {
            mid = (left + right) / 2;
            double midmid = mid * mid;
            if (midmid == x) {
                return Double.valueOf(mid).intValue();
            }
            if (midmid > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return Double.valueOf(mid).intValue();
    }

}
