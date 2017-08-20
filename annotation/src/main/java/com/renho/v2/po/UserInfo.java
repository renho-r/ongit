package com.renho.v2.po;

import com.renho.v2.annotation.FormatAnnotation.*;

/**
 * @author renho
 * @since: 2017/8/17
 */
public class UserInfo {

    @Index(5)
    private Integer id;
    @Index(1)
    private String name;
    @Index(3)
    private String addr;
    @Index(2)
    private String sax;

    public UserInfo(Integer id, String name, String addr) {
        this.id = id;
        this.name = name;
        this.addr = addr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getSax() {
        return sax;
    }

    public void setSax(String sax) {
        this.sax = sax;
    }
}
