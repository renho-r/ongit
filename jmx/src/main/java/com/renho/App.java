package com.renho;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws MalformedObjectNameException, IOException, AttributeNotFoundException, InvalidAttributeValueException, ReflectionException, InstanceNotFoundException, MBeanException, IntrospectionException {

        JMXServiceURL serviceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
        JMXConnector jmxConnector = JMXConnectorFactory.connect(serviceURL, null);
        MBeanServerConnection connection = jmxConnector.getMBeanServerConnection();

        ObjectName objectName = new ObjectName("org.dromara.soul.admin.config:name=PluginCanAuthBean");

//        PluginCanAuthBean proxy = MBeanServerInvocationHandler.newProxyInstance(connection, objectName, PluginCanAuthBean.class, false);
//        proxy.addPlugin("sign");

//        connection.invoke(objectName, "addPlugin", new String[]{"sign"}, new String[]{String.class.getName()} );
        connection.invoke(objectName, "removePlugin", new String[]{"sign"}, new String[]{String.class.getName()} );
        jmxConnector.close();
    }

}
