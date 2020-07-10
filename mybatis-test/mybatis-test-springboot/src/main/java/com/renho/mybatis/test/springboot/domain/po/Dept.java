package com.renho.mybatis.test.springboot.domain.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Data
public class Dept implements Serializable {

    private Integer id;
    private String name;

}
