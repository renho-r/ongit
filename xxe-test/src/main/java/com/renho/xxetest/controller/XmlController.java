package com.renho.xxetest.controller;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;


/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/api/xml")
public class XmlController {

    @PostMapping("/test")
    public String test(@RequestBody String xml) throws IOException, JDOMException {
        InputStream in = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List list = root.getChildren();
        Iterator it = list.iterator();
        String username = null;
        while(it.hasNext()) {
            Element e = (Element) it.next();
            username = e.getText();
        }
        //关闭流  
        in.close();
        return username;
    }
    //界面发送
    /*<?xml version="1.0" encoding="utf-8"?>
    <!DOCTYPE entity [
    <!ENTITY file SYSTEM "file:///F:\workspace\ongit\spring-boot-demo\spring-boot-demo-mybatis\src\main\resources\application.yml">
    ]>
    <xml>
    <username>&file;</username>
    </xml>*/
}
