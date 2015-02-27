package com.renho;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Main {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAXBuilder builder = new SAXBuilder();
		String filePath = System.getProperty("user.dir") + "/bin/com/renho/doImport.xml";
		System.out.println(filePath);
		try {        
//			Document doc = builder.build(new File("file/disk.xml"));
			Document doc = builder.build(new File(filePath));
			Element rootEl = doc.getRootElement();
			//获得所有子元素        
			List<Element> list = new ArrayList<Element>(); 
			list = rootEl.getChildren();
			String tableName = "KC20";
			for (Element el : list) {
				String name = el.getAttributeValue("name");
				if(tableName.equals(name)) {
					System.out.println("表名:" + name);
					List<Element> fieldList =  new ArrayList<Element>();
					fieldList = el.getChildren();
					
					List<Element> listTest = new ArrayList<Element>();
					for(Element e:fieldList) {
						listTest.add(e);
					}

					ComparatorList comparatorList = new ComparatorList();
					Collections.sort(fieldList, comparatorList);
					for(Element e:fieldList) {
						System.out.print(e.getAttributeValue("name"));
						System.out.print("-" + e.getAttributeValue("length"));
						System.out.print("-" + e.getAttributeValue("nonull"));
						System.out.println("-" + e.getAttributeValue("index"));
					}
				}
			}   
		} catch (JDOMException e) {
			e.printStackTrace();    
		} catch (IOException e) {
			e.printStackTrace();  
		}
	}
}
