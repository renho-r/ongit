package com.renho.mybatis.test.only.domain.po;

import lombok.Data;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Data
public class Blog {

    private Integer id;
    private String name;
    private String address;
    private String desc;
    private Long createTime;

}
