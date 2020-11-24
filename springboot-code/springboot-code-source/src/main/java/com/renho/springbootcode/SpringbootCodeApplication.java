package com.renho.springbootcode;

import com.renho.springbootcode.domain.pojo.TbUser;
import com.renho.springbootcode.mapper.TbUserMapper;
import com.renho.my.starter.MyStarterService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * @author renho
 */
@SpringBootApplication
@MapperScan("com.renho.springbootcode.mapper")
public class SpringbootCodeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootCodeApplication.class, args);
//        TbUserMapper userMapper = (TbUserMapper) context.getBean("tbUserMapper");
//        List<TbUser> users = userMapper.findAllUser();
//        users.forEach(System.out::println);
//
//        userMapper.insert(new TbUser(null, "renho"));
//
//        MyStarterService myStarterService = (MyStarterService) context.getBean("myStarterService");
//        System.out.println(myStarterService);
    }

}

