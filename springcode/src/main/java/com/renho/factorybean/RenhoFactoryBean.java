package com.renho.factorybean;

import com.renho.bean.pojo.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class RenhoFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new Person();
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
