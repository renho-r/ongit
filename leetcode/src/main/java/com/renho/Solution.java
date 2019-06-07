package com.renho;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Solution {


    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        Map<String, Character> keys = new HashMap<>();
        keys.put("(", ')');
        keys.put("{", '}');
        keys.put("[", ']');

        Stack<Character> stack = new Stack<>();
    }

    public String delFC(String s, Map<String, Character> keys) {
        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i+1) == keys.get(s.charAt(i))) {

            }
        }
        return null;
    }
}
