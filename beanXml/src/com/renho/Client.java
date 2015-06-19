package com.renho;

import java.io.IOException;

import org.jdom.JDOMException;

import com.renho.utils.BeanXmlUtil;
import com.renho.utils.XmlBean;

public class Client {

	public static void main(String[] args) throws JDOMException, IOException {
		XmlBean xmlBean = BeanXmlUtil.getXmlBean("User.xml");
		System.out.println(xmlBean.getQuerySql());
		xmlBean = BeanXmlUtil.getXmlBean("Role.xml");
		System.out.println(xmlBean.getQuerySql());
		xmlBean = BeanXmlUtil.getXmlBean("UserRole.xml");
		System.out.println(xmlBean.getQuerySql());
	}

}
