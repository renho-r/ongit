package com.renho.spring5code.configuration.factorybean;

import com.renho.spring5code.module.MyBean;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class MyFactoryBean implements FactoryBean<MyBean> {

    @Override
    public MyBean getObject() throws Exception {
        return new MyBean();
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
