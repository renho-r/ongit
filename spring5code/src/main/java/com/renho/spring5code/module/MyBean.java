package com.renho.spring5code.module;

import lombok.Setter;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Setter
public class MyBean {

    private String name;

    public MyBean() {
    }

    public MyBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
