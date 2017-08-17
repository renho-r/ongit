package com.renho.v2.po;

import com.renho.v2.annotation.FormatAnnotation.*;

/**
 * @author renho
 * @since: 2017/8/17
 */
public class UserInfo {

    @Index(1)
    private Integer id;
    @Index(2)
    private String name;
    @Index(3)
    private String addr;
    @Index(4)
    private String sax;

    public UserInfo(Integer id, String name, String addr) {
        this.id = id;
        this.name = name;
        this.addr = addr;
    }
}
