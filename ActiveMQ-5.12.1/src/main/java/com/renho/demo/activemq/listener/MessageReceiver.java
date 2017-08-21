package com.renho.demo.activemq.listener;

import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component("messageReceiver")
public class MessageReceiver implements MessageListener {

    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                String text = textMessage.getText();
                System.out.println(String.format("Received: %s", text));
                throw new JMSException("process failed");
            } catch (JMSException e) {
                System.out.println("there is JMS exception: " + e.getMessage());
                throw JmsUtils.convertJmsAccessException(e);
            }
        }
    }
}