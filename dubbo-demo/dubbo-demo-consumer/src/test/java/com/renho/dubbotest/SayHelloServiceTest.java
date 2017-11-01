package com.renho.dubbotest;

import com.renho.dubbotest.service.ISayHelloService;
import com.renho.dubbotest.tasks.DubboRequest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SayHelloServiceTest {

    @Test
    public void testSayHello() throws InterruptedException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("remote-consumer.xml");
        ISayHelloService sayHelloService = (ISayHelloService) ac.getBean("sayHelloService");
        List<Callable<Object>> tasks = new ArrayList<>();
        for(int i=0; i<100; i++) {
            tasks.add(new DubboRequest(i+"", sayHelloService));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        List<Future<Object>> results = executorService.invokeAll(tasks);
        results.forEach(f -> {
            try {
                f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }

}
