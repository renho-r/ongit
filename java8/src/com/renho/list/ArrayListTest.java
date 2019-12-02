package com.renho.list;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: renho
 * @since: 1.0.0
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
        //elementData 就是ArrayList用于底层存储数据的数组,
        //我们通过观察数组长度的变化来证明我们所说的扩容机制正确性
        Field f = c.getDeclaredField("elementData");
        //设置可访问
        f.setAccessible(true);
        //反射对象
        Object[] elementData = (Object[])f.get(list);
        System.out.println("elementData.length:" + elementData.length + ", size:" + list.size());
    }
}
