package com.renho.sax;

/**
 * @author renho
 * @since: 2017/10/12
 */

import java.util.ArrayList;
import java.util.List;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 功能描述:采用sax方式解析XML<br>
 *
 * @author sxyx2008
 */
public class SaxParseXml extends DefaultHandler {

    //存放遍历集合
    private List<Field> list;
    //构建Field对象
    private Field field;
    //用来存放每次遍历后的元素名称(节点名称)
    private String tagName;

    public List<Field> getList() {
        return list;
    }

    public void setList(List<Field> list) {
        this.list = list;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field Field) {
        this.field = field;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    //只调用一次  初始化list集合
    @Override
    public void startDocument() throws SAXException {
        list = new ArrayList<Field>();
    }

    //调用多次    开始解析
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if (qName.equals("field")) {
            field = new Field();
            //获取Field节点上的id属性值
            field.setName(attributes.getValue(0));
            //获取Field节点上的group属性值
            field.setLength(attributes.getValue(1));
        }
        this.tagName = qName;
    }

    //调用多次
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals("field")) {
            this.list.add(this.field);
        }
        this.tagName = null;
    }

    //只调用一次
    @Override
    public void endDocument() throws SAXException {
    }

    //调用多次
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (this.tagName != null) {
            String data = new String(ch, start, length);
            if (this.tagName.equals("id")) {
                this.field.setId(data);
            }
        }
    }
}