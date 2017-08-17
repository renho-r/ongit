package com.renho.demo.activemq.listener;

/**
 * Created by renho on 2017/8/16.
 */

public class ConsumerMessageAdapterListener {

    public void handleMessage(String message) {
        System.out.println("ConsumerListener通过handleMessage接收到一个纯文本消息，消息内容是：" + message);
    }

    public void receiveMessage(String message) {
        System.out.println("ConsumerListener通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);
    }

}