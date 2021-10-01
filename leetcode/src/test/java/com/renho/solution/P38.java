package com.renho.solution;

/**
 * @author renho
 * @date 2021/7/6
 */
public class P38 {

    public static void main(String[] args) {
        P38 p38 = new P38();
        for (int i=1; i<31; i++) {
            System.out.println(p38.countAndSay(i));
        }
    }

    public String countAndSay(int n) {
        if (1 == n) {
            return "1";
        }
        String cur = "1";
        for (int i=1; i<n; i++) {
            cur = descCur(cur);
        }
        return cur;
    }

    public String descCur(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        int count = 0;
        Character curChar = chars[0];
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == curChar) {
                count++;
            } else {
                sb.append(count).append(curChar);
                curChar = chars[i];
                count = 1;
            }
        }
        sb.append(count).append(curChar);
        return sb.toString();
    }
}
