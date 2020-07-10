package com.renho;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */

import java.lang.management.ManagementFactory;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * 需要打成jar包测试
 */
public class HelloAgent {
    public static void main(String[] args) throws JMException, Exception {

        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("jmxBean:name=hello");
        server.registerMBean(new Hello(), helloName);
        Thread.sleep(60 * 60 * 1000);
    }
}
