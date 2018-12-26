package com.renho.spring5code.configuration;

import com.renho.spring5code.configuration.condition.MyCondition;
import com.renho.spring5code.configuration.typefilter.MyTypeFilter;
import com.renho.spring5code.module.MyBean;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Configuration
@ComponentScan(value = "com.renho.spring5code")
//@ComponentScan(value = "com.renho.spring5code", excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
//}, useDefaultFilters = false)
////@ComponentScans
//@ComponentScan(value = "com.renho.spring5code", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
//}, useDefaultFilters = false)
public class MyConfiguration {

//    @Scope("prototype")
    @Conditional({MyCondition.class})
    @Bean
    public MyBean myBeanR0() {
        System.out.println("create myBean");
        return new MyBean("r0");
    }

//    @Conditional({MyCondition01.class})
    @Bean
    public MyBean myBeanR1() {
        System.out.println("create myBean");
        return new MyBean("r1");
    }

    @Bean
    public MyBean myBeanR2() {
        System.out.println("create myBean");
        return new MyBean("r2");
    }

}
