package com.renho.springbootcode.runner;

import com.renho.springbootcode.SpringbootCodeApplication;
import com.renho.springbootcode.mapper.RenhoMapp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Type;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Component
public class MyRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyRunner: run");
        Class clazz = SubMy.class;
        Type[] types = clazz.getGenericInterfaces();
        Type type = types[0];
        ParameterizedTypeImpl ptype = (ParameterizedTypeImpl) type;
        String typeName = ptype.getTypeName();
        System.out.println(ptype.getActualTypeArguments()[0]);
    }

    interface My<T> {
        default void insert(T t) {
            System.out.println("default");
        }
    }

    interface SubMy extends My<RenhoMapp> {
    }
}
