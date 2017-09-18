package com.renho.demo.security.write;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMapMessage;

import javax.jms.*;

public class Publisher {

    private final ActiveMQConnectionFactory factory;
    private final Connection connection;
    private final Session session;
    private final MessageProducer producer;
    private final String brokerURL = "tcp://127.0.0.1:61616";
    private final String userName = "r_write_user";
    private final String passwd = "r_write_passwd";
    private Destination[] topicDestinations;
    private Destination[] queueDestinations;

    public Publisher() throws JMSException {
        factory = new ActiveMQConnectionFactory(userName, passwd, brokerURL);
        connection = factory.createConnection();
        try {
            connection.start();
        } catch (JMSException jmse) {
            connection.close();
            throw jmse;
        }
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        producer = session.createProducer(null);
    }

    protected void setTopics(String[] stocks) throws JMSException {
        topicDestinations = new Destination[stocks.length];
        for(int i = 0; i < stocks.length; i++) {
            topicDestinations[i] = session.createTopic("renho." + stocks[i]);
        }
    }

    protected void sendTopicMessage(String[] stocks) throws JMSException {
        for(int i = 0; i < stocks.length; i++) {
            Message message = createStockMessage(stocks[i], session);
            System.out.println("Sending: " + ((ActiveMQMapMessage)message).getContentMap() + " on destination: " + topicDestinations[i]);
            producer.send(topicDestinations[i], message);
        }
    }

    protected Message createStockMessage(String stock, Session session) throws JMSException {
        MapMessage message = session.createMapMessage();
        message.setString("stock", stock);
        message.setDouble("price", 1.00);
        message.setDouble("offer", 0.01);
        message.setBoolean("up", true);

        return message;
    }

    public void close() {
        if(null != session) {
            try {
                this.session.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

        if(null != connection) {
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    public void setQueues(String[] queues) throws JMSException {
        queueDestinations = new Destination[queues.length];
        for(int i = 0; i < queues.length; i++) {
            queueDestinations[i] = session.createQueue("renho." + queues[i]);
        }
    }

    public void sendQueueMessage(String[] queuess) throws JMSException {
        for(int i = 0; i < queuess.length; i++) {
            Message message = createStockMessage(queuess[i], session);
            System.out.println("Sending: " + ((ActiveMQMapMessage)message).getContentMap() + " on destination: " + queueDestinations[i]);
            producer.send(queueDestinations[i], message);
        }
    }
}
