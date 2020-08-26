package com.renho.mybatis.test.springboot.multi.domain.po;

import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Data
public class User {

    private Integer id;
    private String name;
    private Integer synced;

    public void request() {
        try {
            System.out.println(this.id + " request");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
