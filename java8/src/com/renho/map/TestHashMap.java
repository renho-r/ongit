package com.renho.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author renho
 * @since: 2019/10/30
 */
public class TestHashMap {

    public static void main(String[] args) {
        Map<MyKey, String> map = new HashMap<>(2);
        map.put(myKey(), "value-1");
        map.put(myKey(), "value-2");
    }

    private static MyKey myKey() {
        return new MyKey();
    }

}
