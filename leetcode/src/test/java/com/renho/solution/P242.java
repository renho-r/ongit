package com.renho.solution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P242 {

    @Test
    public void test() {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        char tmp;
        for(int i=0; i<s.length(); i++) {
            tmp = s.charAt(i);
            if (!sMap.containsKey(tmp)) {
                sMap.put(tmp, 1);
            } else {
                sMap.put(tmp, sMap.get(tmp) + 1);
            }
        }

        for(int i=0; i<t.length(); i++) {
            tmp = t.charAt(i);
            if(!sMap.containsKey(tmp)) {
                return false;
            }
            sMap.put(tmp, sMap.get(tmp) - 1);
            if(sMap.get(tmp) == 0) {
                sMap.remove(tmp);
            }
        }
        return sMap.size() == 0;
    }

}
