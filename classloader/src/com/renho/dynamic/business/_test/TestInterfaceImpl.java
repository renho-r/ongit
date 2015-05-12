package com.renho.dynamic.business._test;

import com.renho.dynamic.ClassLoader.SuperClassLoader;
import com.renho.dynamic.ClassLoader.impl.GeneralClassLoader;
import com.renho.dynamic.business.businessClass.SuperClass;
import com.renho.dynamic.utils.ClassLoaderUtil;
public class TestInterfaceImpl extends SuperClass {
	
	public TestInterfaceImpl() {
		super();
		super.setInterfaceId("TestInterfaceImpl");
	}

	@Override
	public void businessStart() {
		System.out.println("business start");
		System.out.println("classLoaderId:" + super.getClassLoaderId());
		System.out.println("interfaceId:" + super.getInterfaceId());
		SuperClassLoader scl = (GeneralClassLoader) ClassLoaderUtil.getClassLoder(getClassLoaderId());
		Class<?> clazz = scl.getClass("com.renho.dynamic.business._test.Test0");
		Test0 test0;
		try {
			test0 = (Test0) clazz.newInstance();
			test0.show();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
}
