package com.renho.esbtestservice.ws.config;

import com.renho.esbtestservice.ws.AuthServiceImpl;
import com.renho.esbtestservice.ws.LogServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @auther: renho
 * @since: 1.0.0
 */
@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint authEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new AuthServiceImpl());
        endpoint.publish("/ws/auth");
        return endpoint;
    }

    @Bean
    public Endpoint logEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new LogServiceImpl());
        endpoint.publish("/ws/log");
        return endpoint;
    }
}
