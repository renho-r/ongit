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
public class P22 {

    @Test
    public void test() {
        System.out.println(generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        rGen(0, 0, n, "", result);
        return result;
    }

    private void rGen(int left, int right, int n, String nowStr, List<String> result) {
        if(left==n && right==n) {
            result.add(nowStr);
        }
        if(left < n) {
            rGen(left+1, right, n,nowStr+"(", result);
        }
        if(right<n && right<left) {
            rGen(left, right+1, n, nowStr+")", result);
        }
    }

}
