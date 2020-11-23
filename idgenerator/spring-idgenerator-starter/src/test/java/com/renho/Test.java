package com.renho;

/**
 * @author renho
 * @date 2020/10/28
 */
public class Test {

    public int i;
    public final long y = 10 + i;

    public Test(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        Test test = new Test(111);
        System.out.println(test.i);
        System.out.println(test.y);
    }

}
