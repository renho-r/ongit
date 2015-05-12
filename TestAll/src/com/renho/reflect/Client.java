package com.renho.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;

import com.renho.reflect.pojo.User;

public class Client {

	public static void main(String[] args){
		
		User user = new User();
		
		Field[] fields = User.class.getFields();//获取public field
		for(Field field:fields) {
			System.out.println(field.getName());
		}
		
		fields = User.class.getDeclaredFields();//获取包含private field
		for(Field field:fields) {
			System.out.println(field.getName());
		}
		
		
		Field field;
		try {
			field = User.class.getField("userName");
			System.out.println(field);
		} catch (NoSuchFieldException | SecurityException e) {
			System.out.println("吃掉");
		}
		
//		Method[] methods = User.class.getMethods();//包括父类method, 不包括private
		Method[] methods = User.class.getDeclaredMethods();//只自己method, 包括private
		for(Method method:methods) {
			System.out.println("getMethods---------" + method.getName());
			try {
				if(method.getName().startsWith("set")) {
					if("setUserId".equals(method.getName())) {
						method.invoke(user, new Object[]{1});
					}
					if("setUserName".equals(method.getName())) {
						method.invoke(user, new Object[]{"renho"});
					}
					if("setUpdateTime".equals(method.getName())) {
						Date date = new Date();
						long time = date.getTime();
						method.invoke(user, new Object[]{new Timestamp(time)});
					}
				}
				if("show".equals(method.getName())) {
					method.setAccessible(true);
					method.invoke(user, null);
				}
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(user.getUserId());
		System.out.println(user.getUserName());
		System.out.println(user.getUpdateTime());
	}

}
