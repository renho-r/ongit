package com.renho.spring.service.impl;

import com.renho.spring.service.IUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Service
@Scope("request")
public class UserServiceImpl implements IUserService {
}
