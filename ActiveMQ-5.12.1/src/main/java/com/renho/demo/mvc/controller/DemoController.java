package com.renho.demo.mvc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.renho.demo.activemq.consumer.ConsumerService;
import com.renho.demo.activemq.producer.ProducerService;

@Controller
public class DemoController {


    //队列名renho.demo
    @Resource(name = "demoQueueDestination")
    private Destination demoQueueDestination;

    //队列消息生产者
    @Resource(name = "producerService")
    private ProducerService producer;

    //队列消息消费者
    @Resource(name = "consumerService")
    private ConsumerService consumer;

    @RequestMapping(value = "/producer", method = RequestMethod.GET)
    public ModelAndView producer() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(now);

        ModelAndView mv = new ModelAndView();
        mv.addObject("time", time);
        mv.setViewName("jms_producer");
        return mv;
    }

    @RequestMapping(value = "/onsend", method = RequestMethod.POST)
    public String producer(@RequestParam("message") String message) {
//        ModelAndView mv = new ModelAndView();
        producer.sendMessage(demoQueueDestination, message);
        producer.sendMessage(message);
//        mv.setViewName("redirect:/jms_producer");
        return "redirect:/producer";
    }

    @RequestMapping(value = "/receive", method = RequestMethod.GET)
    public ModelAndView queue_receive() throws JMSException {
        ModelAndView mv = new ModelAndView();

        TextMessage tm = consumer.receive(demoQueueDestination);
        mv.addObject("textMessage", tm.getText());

        mv.setViewName("queue_receive");
        return mv;
    }

    /*
     * ActiveMQ Manager Test
     */
    @RequestMapping(value = "/jms", method = RequestMethod.GET)
    public ModelAndView jmsManager() throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");

        JMXServiceURL url = new JMXServiceURL("");
        JMXConnector connector = JMXConnectorFactory.connect(url);
        connector.connect();
        MBeanServerConnection connection = connector.getMBeanServerConnection();

        return mv;
    }

    @RequestMapping(value = "/sendAndReceive/{message}", method = RequestMethod.GET)
    public String sendAndReceive(@PathVariable("message") String message) {
        producer.sendAndReceiveMessage(message);
        return "redirect:/producer";
    }
}