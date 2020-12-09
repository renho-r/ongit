package com.renho.springbootcode;

import com.renho.springbootcode.domain.pojo.TbUser;
import com.renho.springbootcode.mapper.RenhoMapp;
import com.renho.springbootcode.mapper.TbUserMapper;
import com.renho.springbootcode.myproxy.RenhoProxy;
import com.renho.springbootcode.service.IMyService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author renho
 */
@SpringBootApplication
@MapperScan("com.renho.springbootcode.mapper")
@RenhoProxy("com.renho.springbootcode.myproxy.mybean")
public class SpringbootCodeApplication {

    private static Environment env;

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringbootCodeApplication.class, args);
//        IMyService myService = context.getBean(IMyService.class);
//        myService.testCommit();
//        System.out.println(env.getProperty("renho.param"));
//        System.out.println(env.getProperty("my-renho-propertiy"));
//        MyTarget myTarget = context.getBean(MyTarget.class);
//        System.out.println(myTarget.show("renho"));
//        IRenho renho = context.getBean(IRenho.class);
//        renho.show();
//        IRenho2 renho2 = context.getBean(IRenho2.class);
//        renho2.show();
//        RenhoMapp renhoMapp = (RenhoMapp) context.getBean("renhoMapp");
//        renhoMapp.findAllUser();
        TbUserMapper userMapper = (TbUserMapper) context.getBean("tbUserMapper");
        List<TbUser> users = userMapper.findAllUser();
        users.forEach(System.out::println);
//
//        userMapper.insert(new TbUser(null, "renho"));
//
//        MyStarterService myStarterService = (MyStarterService) context.getBean("myStarterService");
//        System.out.println(myStarterService);
        System.out.println("done");
    }

    @Autowired
    public void setEnv(Environment env) {
        SpringbootCodeApplication.env = env;
    }
}

