package com.renho.solution;

/**
 * @author renho
 * @date 2021/6/29
 */
public class P168 {

    public static void main(String[] args) {
        P168 p168 = new P168();
        String result = p168.convertToTitle(27);
        System.out.println(result);
    }

    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 26) {
            return new Character((char)(columnNumber + 'A' - 1)).toString();
        }
        int mod = (columnNumber - 1) % 26;
        int t = (columnNumber - mod) / 26;
        return convertToTitle(t) + new Character((char)(mod + 'A')).toString();
    }


}
