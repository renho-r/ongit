package com.renho.mybatis.test.springboot.multi.pool;

import com.renho.mybatis.test.springboot.multi.domain.po.User;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class UserPooledObjectFactory extends BasePooledObjectFactory<User> {

    private volatile int i = 0;

    @Override
    public User create() throws Exception {
        User user = new User();
        user.setId(i++);
        return user;
    }

    @Override
    public PooledObject<User> wrap(User obj) {
        return new DefaultPooledObject<User>(obj);
    }
}
