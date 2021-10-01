package com.renho.service.impl;

import com.renho.dao.IRenhoDAO;
import com.renho.service.IRenhoService;

/**
 * @author renho
 * @date 2021/9/5
 */
public class RenhoServiceImpl implements IRenhoService {

    private IRenhoDAO renhoDAO;

    @Override
    public void show(String name) {
        System.out.println("renhoService: " + this.renhoDAO.show(name));
    }

    public IRenhoDAO getRenhoDAO() {
        return renhoDAO;
    }

    public void setRenhoDAO(IRenhoDAO renhoDAO) {
        this.renhoDAO = renhoDAO;
    }
}
