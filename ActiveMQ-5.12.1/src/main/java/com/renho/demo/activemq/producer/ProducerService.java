package com.renho.demo.activemq.producer;

import javax.annotation.Resource;
import javax.jms.*;

import com.renho.demo.entity.Query;
import com.renho.demo.entity.User;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;

    //@Resource(name="jmsTemplateSessionAwareQueue")
    private JmsTemplate jmsTemplateSessionAwareQueue;

    @Resource(name="jmsSendTemplate")
    private JmsTemplate jmsSendTemplate;

    /**
     * 向指定队列发送消息
     */
    public void sendMessage(Destination destination, final String msg) {
        System.out.println("向队列" + destination.toString() + "发送了消息------------" + msg);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }

    /**
     * 向默认队列发送消息
     */
    public void sendMessage(final String msg) {
        String destination =  jmsTemplate.getDefaultDestination().toString();
        System.out.println("向队列" +destination+ "发送了消息------------" + msg);
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
        jmsTemplateSessionAwareQueue.convertAndSend(msg);
    }

    /**
     * send and receive
     */
    public void sendAndReceiveMessage(final String msg) {
        String destination =  jmsTemplate.getDefaultDestination().toString();
        System.out.println("向队列" +destination+ "发送了消息------------" + msg);
        ObjectMessage objMsg = (ObjectMessage) jmsSendTemplate.sendAndReceive(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(new Query(Integer.valueOf(msg)));
            }
        });
        try {
            User user = (User) objMsg.getObject();
            System.out.println("get receive user: " + user.getName());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}