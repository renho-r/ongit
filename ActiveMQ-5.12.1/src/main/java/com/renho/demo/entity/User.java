package com.renho.demo.entity;

import java.io.Serializable;

/**
 * Created by renho on 2017/8/16.
 */
public class User implements Serializable{

    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
