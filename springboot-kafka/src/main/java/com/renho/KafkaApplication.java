package com.renho;

import com.renho.kafka.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: renho
 * @since: 1.0.0
 */
@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(KafkaApplication.class, args);
        Producer producer = (Producer) context.getBean("producer");
        producer.send();
        System.out.println("success");
    }
}