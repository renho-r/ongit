package com.renho.beandefinitionregistrar.test;

import com.renho.beandefinitionregistrar.test.mapper.CountryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = BeanDefinitionRegistrarApplication.class)
@SpringBootTest
//@ContextConfiguration(classes = {BeanDefinitionRegistrarAutoConfiguration.class})
public class BeanDefinitionRegistrarApplicationTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    CountryMapper countryMapper;

    @Test
    public void contextLoads() {
        System.out.println(countryMapper.getClass());
    }

}
