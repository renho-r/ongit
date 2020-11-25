package com.renho.springbootcode.myproxy;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author renho
 * @date 2020/11/25
 */
public class RenhoFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
