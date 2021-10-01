package com.renho.controller;

import com.renho.service.IRenhoService;

/**
 * @author renho
 * @date 2021/9/5
 */
public class RenhoController {

    private IRenhoService renhoService;

    public void hello(String name) {
        this.renhoService.show(name);
    }

    public IRenhoService getRenhoService() {
        return renhoService;
    }

    public void setRenhoService(IRenhoService renhoService) {
        this.renhoService = renhoService;
    }
}
