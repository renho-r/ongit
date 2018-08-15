package com.renho.dubbo.admin.test;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.registry.RegistryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dubbo.xml"})
public class DubboServiceManage {

    private static final Logger logger = LoggerFactory.getLogger(DubboServiceManage.class);

    @Autowired
    private RegistryService registryService;

    @Test
    public void lookup() {
        assert null != registryService;
        URL url = new URL("dubbo", "192.168.111.1", 20889);
        url = url.setServiceInterface("com.renho.dubbotest.service.ISayHelloService");
        url = url.setPath("com.renho.dubbotest.service.ISayHelloService");
        List<URL> urls = registryService.lookup(url);
        logger.warn(urls.toString());
    }

    @Test
    public void disabledProvider() {
        URL url = URL.valueOf("override://192.168.111.1:20889/com.renho.dubbotest.service.ISayHelloService?category=configurators&disabled=true&dynamic=false&enabled=true&runtime=true");
        registryService.register(url);
    }

    @Test
    public void disabledConsumer() {
        URL url = URL.valueOf("route://0.0.0.0/com.renho.dubbotest.service.ISayHelloService?category=routers&dynamic=false&enabled=true&force=true&name=com.renho.dubbotest.service.ISayHelloService blackwhitelist&priority=0&router=condition&rule=consumer.host = 192.168.111.1 => false&runtime=false");
        registryService.register(url);
    }

    @Test
    public void eabledConsumer() {
        URL url = URL.valueOf("route://0.0.0.0/com.renho.dubbotest.service.ISayHelloService?category=routers&dynamic=false&enabled=true&force=true&name=com.renho.dubbotest.service.ISayHelloService blackwhitelist&priority=0&router=condition&rule=consumer.host = 192.168.111.1 => false&runtime=false");
        registryService.unregister(url);
    }

}
