package com.renho.dataStructure.sort.all;

import com.renho.dataStructure.sort.all.impl.Bubbling;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Client {

    public static void main(String[] args) {

        int[] arr = new int[] {3, 6, 4, 2, 11, 10, 5};
        ISort sort = new Bubbling();

        sort.sort(arr);

        println(arr);

    }

    public static void println(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            System.out.print(i + ",");
        }
    }

}
