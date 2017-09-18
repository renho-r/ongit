package com.renho.demo.security.write;

import javax.jms.JMSException;

public class Client {

    public static void main(String[] args) throws JMSException {
        String[] topics = new String[]{"demo.topic.publisher"};
        String[] queuess = new String[]{"demo.queue.publisher"};
        // Create publisher
        Publisher publisher = new Publisher();

        // Set topics
        publisher.setTopics(topics);

        // Set queue
        publisher.setQueues(queuess);

        for(int i = 0; i < 10; i++) {
            publisher.sendTopicMessage(topics);
            publisher.sendQueueMessage(queuess);
            System.out.println("Publisher '" + i + " price messages");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Close all resources
        publisher.close();
    }
}
