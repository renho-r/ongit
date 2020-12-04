package com.renho.springcloudlogging.controller;

import com.renho.springcloudlogging.service.IRenhoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renho
 * @date 2020/12/4
 */
@RestController
@RequestMapping("/renho")
public class RenhoController {

    private final static Logger logger = LoggerFactory.getLogger(RenhoController.class);

    public RenhoController() {
        logger.trace("controller info ...");
    }

    @Autowired
    private Environment env;
    @Autowired
    private IRenhoService renhoService;

    @GetMapping("/log")
    public Object test() {
        logger.trace(this.getClass().toGenericString());
        logger.debug(this.getClass().toGenericString());
        logger.info(this.getClass().toGenericString());
        logger.warn(this.getClass().toGenericString());
        logger.error(this.getClass().toGenericString());

        this.renhoService.logInfo();
        return "result";
    }

    @GetMapping("/env/{paramName}")
    public Object env(@PathVariable String paramName) {
        return this.env.getProperty(paramName);
    }

}
