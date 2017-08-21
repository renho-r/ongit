package com.renho.demo.entity;

import java.io.Serializable;

/**
 * Created by renho on 2017/8/16.
 */
public class Query implements Serializable{

    private Integer id;

    public Query(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
