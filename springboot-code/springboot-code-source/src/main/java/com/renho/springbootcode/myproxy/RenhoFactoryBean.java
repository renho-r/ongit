package com.renho.springbootcode.myproxy;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author renho
 * @date 2020/11/25
 */
public class RenhoFactoryBean<T> implements FactoryBean<T> {

    private Class<T> interfaces;

    public RenhoFactoryBean() {
        System.out.println(123);
    }

    public RenhoFactoryBean(Class<T> interfaces) {
        this.interfaces = interfaces;
    }

    @Override
    public T getObject() throws Exception {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[] { interfaces }, new RenhoProxy());
    }

    @Override
    public Class<?> getObjectType() {
        return interfaces;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    private class RenhoProxy implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("RenhoProxy: " + method.getName());
            return null;
        }
    }
}
