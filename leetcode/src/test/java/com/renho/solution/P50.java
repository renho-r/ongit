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
public class P50 {

    @Test
    public void test() {
        System.out.println(myPow(1.00000, -2147483648));
    }

    public double myPow(double x, long n) {
        if(n == 0) {
            return 1.0;
        }
        if(n < 0) {
            return 1/myPow(x, -n);
        }
        if(1 == n%2) {
            return myPow(x * x, n/2) * x;
        } else {
            return myPow(x * x, n/2);
        }
    }

}
