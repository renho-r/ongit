package com.renho.test.factorymethod;

import com.renho.bean.dao.PersonDAO;
import com.renho.bean.pojo.Person;

public class FactoryBeanTest {

	public Object getInstance(String str) {
		Object object = null;
		if("1".equals(str)) {
			object = new PersonDAO();
		}
		return object;
	}
	
	public Object getInstance(String str, Object perObj) {
		Object object = null;
		if("1".equals(str)) {
			object = new PersonDAO();
			((PersonDAO)object).setPerson((Person)perObj);
		}
		return object;
	}
}
