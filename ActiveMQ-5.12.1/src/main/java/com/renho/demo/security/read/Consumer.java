package com.renho.demo.security.read;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

public class Consumer {

    private final String brokerURL = "tcp://127.0.0.1:61616";
    private final String userName = "r_read_user";
    private final String passwd = "r_read_passwd";

    private final ActiveMQConnectionFactory factory;
    private final Connection connection;
    private final Session session;

    public Consumer() throws JMSException {
        factory = new ActiveMQConnectionFactory(userName, passwd, brokerURL);
        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    public Session getSession() {
        return session;
    }
}
