package com.renho.jersey.appconfig;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("resources")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("com.renho.jersey;com.renho.jersey.filter;com.renho.jersey.namebinding;com.renho.jersey.dynamicbinding");
    }
}