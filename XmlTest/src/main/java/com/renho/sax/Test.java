package com.renho.sax;

/**
 * @author renho
 * @since: 2017/10/12
 */

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        SAXParser parser = null;
        try {
            //构建SAXParser
            parser = SAXParserFactory.newInstance().newSAXParser();
            //实例化  DefaultHandler对象
            SaxParseXml parseXml = new SaxParseXml();
            //加载资源文件 转化为一个输入流
            InputStream stream = SaxParseXml.class.getClassLoader().getResourceAsStream("doImport.xml");
            //调用parse()方法
            parser.parse(stream, parseXml);
            //遍历结果
            List<Field> list = parseXml.getList();
            for (Field field : list) {
                System.out.printf("name: %s-------->id: %s\n", field.getName(), field.getId());
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}