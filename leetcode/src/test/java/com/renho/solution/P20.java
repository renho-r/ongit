package com.renho.solution;

import com.renho.model.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P20 {

    @Test
    public void test() {

    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap(){{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        char[] stack = new char[s.length()];
        int index = 0;
        char tmp;
        for(int i=0; i<s.length(); i++) {
            tmp = s.charAt(i);
            if(map.containsKey(tmp)) {
                stack[index++] = tmp;
                continue;
            } else {
                if(0==index || !(map.get(stack[index--]) == tmp)) {
                    return false;
                }
            }
        }
        return 0 == index;
    }

}
