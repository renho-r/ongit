package com.renho.demo.security.read;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;

public class Client {

    public static void main(String[] args) throws JMSException {

        String[] topics = new String[]{"demo.topic.publisher"};
        String[] queues = new String[]{"demo.queue.publisher"};

        Consumer consumer = new Consumer();
        for (String topic : topics) {
            Destination destination = consumer.getSession().createTopic("renho." + topic);
            MessageConsumer messageConsumer = consumer.getSession().createConsumer(destination);
            messageConsumer.setMessageListener(new Listener());
        }

        consumer = new Consumer();
        for (String queue : queues) {
                Destination destination = consumer.getSession().createQueue("renho." + queue);
            MessageConsumer messageConsumer = consumer.getSession().createConsumer(destination);
            messageConsumer.setMessageListener(new Listener());
        }
    }

}
