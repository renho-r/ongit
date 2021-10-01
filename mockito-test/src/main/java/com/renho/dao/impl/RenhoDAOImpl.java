package com.renho.dao.impl;

import com.renho.dao.IRenhoDAO;

/**
 * @author renho
 * @date 2021/9/5
 */
public class RenhoDAOImpl implements IRenhoDAO {
    @Override
    public String show(String name) {
        System.out.println("renhoDAO: " + name);
        return "renhoDAO: " + name;
    }
}
