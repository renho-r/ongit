package com.renho.spring.service.impl;

import com.renho.spring.service.IUserService;
<<<<<<< HEAD
import com.renho.spring.util.LogUtil;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public void getUser() {
        LogUtil.logStack();
    }
=======
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Service
@Scope("request")
public class UserServiceImpl implements IUserService {
>>>>>>> 4ccc284a86f8313770f03de4d90a746fb9a76e4b
}
