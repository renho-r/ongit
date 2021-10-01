package com.renho.test.jcdy;

import java.util.LinkedList;

/**
 * @author renho
 * @date 2021/6/30
 */
public class Test {
    public static void main(String[] args) {


        LinkedList s = new LinkedList();
        s.addFirst(1);
        s.addFirst(2);
        s.addFirst(3);
        s.addFirst(4);
        s.addFirst(5);

        System.out.println(s.removeFirst());
        System.out.println(s.removeFirst());
        System.out.println(s.removeFirst());
        System.out.println(s.removeFirst());
        System.out.println(s.removeFirst());
    }
}
