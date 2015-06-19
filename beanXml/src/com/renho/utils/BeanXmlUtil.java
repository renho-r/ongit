package com.renho.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.renho.utils.XmlBean.Field;
import com.renho.utils.XmlBean.Table;
import com.renho.utils.XmlBean.Tables;

public class BeanXmlUtil {

	@SuppressWarnings("unchecked")
	public static XmlBean getXmlBean(String xmlName) throws JDOMException, IOException {
		
		SAXBuilder builder = new SAXBuilder();
		String filePath = System.getProperty("user.dir") + "/bin/" + xmlName;
		
		Document doc = builder.build(new File(filePath));
		Element rootEl = doc.getRootElement();
		//获得所有子元素        
		List<Element> list = new ArrayList<Element>(); 
		list = rootEl.getChildren();
		XmlBean xmlBean = new XmlBean();
		List<Table> tableList = new ArrayList<XmlBean.Table>();
		Tables tables = new Tables();
		for (Element el : list) {
			if("table".equals(el.getName())) {
				Table table = new Table();
				List<Element> elList = el.getChildren();
				List<Field> fields = new ArrayList<XmlBean.Field>();
				for(Element filedEl:elList) {
					Field field = new Field();
					field.setId(filedEl.getAttributeValue("id"));
					field.setColumn(filedEl.getAttributeValue("column"));
					field.setLength(Integer.valueOf(filedEl.getAttributeValue("length")));
					field.setOrderAble(Boolean.valueOf(filedEl.getAttributeValue("orderAble")));
					field.setType(filedEl.getAttributeValue("type"));
					field.setPk(Boolean.valueOf(filedEl.getAttributeValue("pk")));
					fields.add(field);
				}
				table.setFields(fields);
				table.setId(el.getAttributeValue("id"));
				table.setName(el.getAttributeValue("tableName"));
				tableList.add(table);				
			}else if("filter".equals(el.getName())) {
				String filterStr = el.getValue().trim();
				tables.setFilter(filterStr);
			}
		}
		tables.setTables(tableList);
		xmlBean.setTables(tables);
		return xmlBean;
	}
	
}
