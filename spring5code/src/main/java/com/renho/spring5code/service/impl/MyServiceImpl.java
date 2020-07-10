package com.renho.spring5code.service.impl;

import com.renho.spring5code.service.IMyService;
import org.springframework.stereotype.Service;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Service
public class MyServiceImpl implements IMyService {

    public MyServiceImpl() {
        System.out.println("create MyServiceImpl");
    }

}
