package com.renho.jsonInner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.renho.jsonInner.pojo.DataTableParam;
import com.renho.jsonInner.pojo.DataTableParam.Columns;

public class Client1 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		Columns columns = Columns.class.newInstance();
//		columns.setName("renho");
//		System.out.println(columns);
		
		System.out.println(Columns.class.getConstructors().length);
		System.out.println(Columns.class.getConstructors()[0]);
		System.out.println(Columns.class.getConstructors()[1]);
		Constructor constructor = Columns.class.getConstructors()[0];
		Columns columns = (Columns) constructor.newInstance(new DataTableParam());
		columns.setName("renho");
		System.out.println(columns.getName());
	}

}
