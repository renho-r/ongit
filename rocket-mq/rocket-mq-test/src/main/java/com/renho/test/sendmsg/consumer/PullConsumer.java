package com.renho.test.sendmsg.consumer;

import com.renho.test.util.MQTestUtils;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.consumer.store.OffsetStore;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.Collection;
import java.util.List;

/**
 * @author renho
 * @date 2021/6/17
 */
public class PullConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultLitePullConsumer consumer = new DefaultLitePullConsumer("consumer-renho");
        consumer.setNamesrvAddr(MQTestUtils.NAME_SERVER_ADDR);
        OffsetStore os = consumer.getOffsetStore();
        System.out.println(os);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
//        consumer.subscribe("renho", "*");
        consumer.setPullBatchSize(1);
        consumer.setAutoCommit(false);
        consumer.start();
        Collection<MessageQueue> mqs = consumer.fetchMessageQueues("renho");
        consumer.assign(mqs);
        mqs.forEach(mq -> {
            try {
                consumer.seekToBegin(mq);
            } catch (MQClientException e) {
                e.printStackTrace();
            }
        });
        consumer.commitSync();
//        List<MessageExt> msgs = null;
//        while (true) {
//            os = consumer.getOffsetStore();
//            System.out.println(os);
//            System.out.println("第-----------------------次");
//            msgs = consumer.poll();
//            msgs.forEach(msg -> System.out.println(msg));
//            consumer.commitSync();
//
//        }
//        Collection<MessageQueue> mqs = consumer.fetchMessageQueues("topic-name_com-renho-test-sendmsg-producer-AsyncProducer");
//        consumer.assign(mqs);
//        consumer.see
//        for (MessageQueue mq: mqs) {
//            System.out.println(mq.getQueueId());
//        }
        consumer.shutdown();
    }
}
