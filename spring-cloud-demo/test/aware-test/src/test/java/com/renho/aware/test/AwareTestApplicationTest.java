package com.renho.aware.test;

import com.renho.aware.test.ApplicationEventPublisherAware.ApplicationEventPublisherAwareMy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AwareTestApplicationTest {

    @Autowired
    public ApplicationEventPublisherAwareMy applicationEventPublisherAwareMy;

    @Test
    public void applicationEventPublisherAwareTest(){
        applicationEventPublisherAwareMy.publishEvent();
    }

    @Test
    public void servletContextAwareTest(){

    }

}
