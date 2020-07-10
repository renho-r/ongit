package com.renho.spring.service.impl;

import com.renho.spring.service.IUserService;
import com.renho.spring.util.LogUtil;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public void getUser() {
        LogUtil.logStack();
    }
}
