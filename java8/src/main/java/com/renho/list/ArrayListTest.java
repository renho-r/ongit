package com.renho.list;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author renho
 * @since: 2019/11/6
 */
public class ArrayListTest {

    public static void main(String[] args) throws Exception {
        List<Integer> arr = new ArrayList<>();
        print(arr);
        System.out.println(arr);
        for (int i = 0; i < 30; i++) {
            arr.add(i);
            print(arr);
        }
        System.out.println(arr);

        List<Integer> b = new ArrayList<>();
        b.add(1);

        arr.retainAll(b);
        System.out.println(arr);
    }

    static void print(List list) throws Exception {
        Class c = list.getClass();
        Field f = c.getDeclaredField("elementData");
        f.setAccessible(true);
        Object[] elementData = (Object[])f.get(list);
        System.out.println("elementData.length:" + elementData.length + ", size:" + list.size());
    }
}
