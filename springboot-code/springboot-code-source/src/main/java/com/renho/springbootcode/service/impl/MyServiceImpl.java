package com.renho.springbootcode.service.impl;

import com.renho.springbootcode.service.IMyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author renho
 * @date 2020/12/9
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MyServiceImpl implements IMyService {

    @Override
    public void testCommit() {
        System.out.println("MyServiceImpl.testCommit()");
    }

}
