package com.renho.springbootcode.domain.pojo;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class TbUser {

    public TbUser() {}

    public TbUser(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    private Long id;
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
