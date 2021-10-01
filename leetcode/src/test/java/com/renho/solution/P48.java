package com.renho.solution;

import org.junit.Test;

import java.util.*;

public class P48 {

    @Test
    public void test() {
        List<String> test = new ArrayList(){{
            add("abcabcbb");
            add("bbbbb");
            add("pwwkew");
            add("dvdf");
        }};
        test.forEach(t -> System.out.println(lengthOfLongestSubstring(t)));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> subSet = new LinkedHashSet<>();
        int max = 0;
        for (int i=0; i<s.length(); i++) {
            if (subSet.contains(s.charAt(i))) {
                Iterator<Character> it = subSet.iterator();
                while (it.hasNext()) {
                    Character v = it.next();
                    it.remove();
                    if (v.equals(s.charAt(i))) {
                        break;
                    }
                }
            }
            subSet.add(s.charAt(i));
            max = subSet.size() > max? subSet.size(): max;
        }
        return max;
    }
}
