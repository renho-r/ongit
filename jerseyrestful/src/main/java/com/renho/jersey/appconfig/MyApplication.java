package com.renho.jersey.appconfig;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@ApplicationPath("resources")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("com.renho.jersey;com.renho.jersey.filter;com.renho.jersey.namebinding;com.renho.jersey.dynamicbinding");
        register(LoggingFilter.class);
        register(JacksonJsonProvider.class);
    }
}