package org.apache.qpid.example;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by renho on 2016/6/8.
 */
public class HelloReceiver {

    public static void main(String[] args) {
        try (InputStream resourceAsStream = HelloReceiver.class.getResourceAsStream("hello.properties")) {
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            Context context = new InitialContext(properties);

            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("qpidConnectionfactory");
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = (Destination) context.lookup("fanoutExchange");
            MessageConsumer messageConsumer = session.createConsumer(destination);
            TextMessage message = (TextMessage) messageConsumer.receive();
            System.out.println(message.getText());
            connection.close();
            context.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
