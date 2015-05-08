package com.renho.target;

import com.renho.target.TestTarget;
import com.renho.target.TestTarget.TYPE_RENHO;
import com.renho.target.pojo.User;

public class Main {

	public static void main(String[] args) {
		
		User user = new User();
		
		TYPE_RENHO tr = User.class.getAnnotation(TestTarget.TYPE_RENHO.class);
		String tableName = tr.tableName();
		System.out.println("tableName:" + tableName);
		
		System.out.println(user.getClass().getAnnotation(TestTarget.FIELD_RENHO.class));
		System.out.println(user.getClass().getAnnotation(TestTarget.METHOD_RENHO.class));
	}

}
