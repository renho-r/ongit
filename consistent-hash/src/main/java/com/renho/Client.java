package com.renho;

import java.util.ArrayList;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        ConsistentHash<String> ch = new ConsistentHash(1, new ArrayList(){{
            add("10.1.1.1");
            add("10.1.1.2");
            add("10.1.1.3");
        }});
        System.out.println(ch.get("renho"));
        ch.add("10.1.1.4");
        System.out.println(ch.get("renho"));
        ch.remove("renho");
    }

}
