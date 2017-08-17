package com.renho.demo.activemq.listener;

import com.renho.demo.entity.Query;
import com.renho.demo.entity.User;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created by renho on 2017/8/16.
 */
public class ConsumerReceiveAndBackMessageListener implements MessageListener {

    private JmsTemplate jmsTemplate;

    public void onMessage(Message message) {

        System.out.println("ConsumerReceiveAndBackMessageListener接收到一个纯文本消息。");
        ObjectMessage objMsg = (ObjectMessage) message;
        Query query;
        try {
            query = (Query) objMsg.getObject();
            System.out.println("消息内容是：" + query.getId());
            Destination destination = message.getJMSReplyTo();
            User user = new User();
            user.setId(query.getId());
            user.setName("renho");
            jmsTemplate.convertAndSend(destination, user);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
