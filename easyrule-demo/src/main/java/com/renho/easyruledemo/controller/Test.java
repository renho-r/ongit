package com.renho.easyruledemo.controller;

import com.renho.easyruledemo.WeatherRule;
import com.renho.easyruledemo.classloader.DiskClassLoader;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLClassLoader;

@RequestMapping("")
@Controller
public class Test {

    @ResponseBody
    @RequestMapping("/test")
    public String test() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

//        System.out.println(this.getClass().getClassLoader().getParent());
//        System.out.println(Class.forName(Rule.class.getName()).getClassLoader());
//        DiskClassLoader diskClassLoader = new DiskClassLoader("D:\\workspace", Class.forName(Rule.class.getName()).getClassLoader());
        DiskClassLoader diskClassLoader = new DiskClassLoader("/root/test", Class.forName(Rule.class.getName()).getClassLoader());
//        System.out.println(diskClassLoader.getParent());
        Class clazz = diskClassLoader.loadClass("com.renho.annotation.Test");
        Object testRule = clazz.newInstance();

//        Class.forName(Rule.class.getName());
        RulesEngine rulesEngine = new DefaultRulesEngine();
        Rules rules = new Rules();
//        WeatherRule weatherRule = new WeatherRule();
//        rules.register(weatherRule);
//        System.out.println(weatherRule.getClass().getAnnotations().length);
//        System.out.println("register success ...");
//        System.out.println(weatherRule.getClass().getClassLoader());
//        System.out.println(testRule.getClass().getClassLoader());
        rules.register(testRule);

        Facts facts = new Facts();
        facts.put("rain", true);
        rulesEngine.fire(rules, facts);
        return "success";
    }

}
