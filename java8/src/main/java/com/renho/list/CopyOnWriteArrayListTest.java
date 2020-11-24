package com.renho.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.remove(3);
    }

}
