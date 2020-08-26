package com.renho.map;

import java.util.HashMap;
<<<<<<< HEAD
import java.util.Map;

/**
 * @author renho
 * @since: 2019/10/30
=======
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author: renho
 * @since: 1.0.0
>>>>>>> 6997397a7f75bd3e5b9ef0dcf835840fff208b23
 */
public class TestHashMap {

    public static void main(String[] args) {
<<<<<<< HEAD
        Map<MyKey, String> map = new HashMap<>(2);
        map.put(myKey(), "value-1");
        map.put(myKey(), "value-2");
=======

        Map<MyKey, String> map1 = new HashMap<>(1, 0.75f);
        map1.put(null, "value-0");
        map1.put(myKey(), "value-1");
        map1.put(myKey(), "value-2");

        Set<MyKey> keys = map1.keySet();
        System.out.printf("%s\n", keys);

        Iterator<MyKey> itKey = keys.iterator();
        if (itKey.hasNext()) {
            System.out.printf("%s\n", itKey.next());
        }

        Set<Map.Entry<MyKey, String>> entry = map1.entrySet();
        Iterator<Map.Entry<MyKey, String>> node = entry.iterator();
        if (node.hasNext()) {
            System.out.printf("%s\n", node.next());
        }
>>>>>>> 6997397a7f75bd3e5b9ef0dcf835840fff208b23
    }

    private static MyKey myKey() {
        return new MyKey();
    }

}
