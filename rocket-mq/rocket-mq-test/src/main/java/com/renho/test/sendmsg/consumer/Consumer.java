package com.renho.test.sendmsg.consumer;

import com.renho.test.util.MQTestUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author renho
 * @date 2021/6/17
 */
public class Consumer {
    public static void main(String[] args) throws InterruptedException, MQClientException {

        // 实例化消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(MQTestUtils.genericConsumerGroupName());

        // 设置NameServer的地址
        consumer.setNamesrvAddr(MQTestUtils.NAME_SERVER_ADDR);

        // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息
//        consumer.subscribe("topic-name_com-renho-test-sendmsg-producer-AsyncProducer", "*");
        consumer.subscribe("TopicTest", "*");
        // 注册回调实现类来处理从broker拉取回来的消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                // 标记该消息已经被成功消费
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//                System.out.println(100/0);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动消费者实例
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}
