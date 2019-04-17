package com.renho.springcloud.reference.RefreshScope.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.util.Map;

/**
 * @author: renho
 * @since: 1.0.0
 */
//@Configuration
//@EnableDiscoveryClient(autoRegister=false)
public class MyConfiguration {

    private ServiceRegistry registry;

    public MyConfiguration(ServiceRegistry registry) {
        this.registry = registry;
    }

    // called via some external process, such as an event or a custom actuator endpoint
    public void register() {
        Registration registration = constructRegistration();
        this.registry.register(registration);
    }

    private Registration constructRegistration() {
        return new Registration() {
            @Override
            public String getServiceId() {
                return null;
            }

            @Override
            public String getHost() {
                return null;
            }

            @Override
            public int getPort() {
                return 0;
            }

            @Override
            public boolean isSecure() {
                return false;
            }

            @Override
            public URI getUri() {
                return null;
            }

            @Override
            public Map<String, String> getMetadata() {
                return null;
            }
        };
    }
}
