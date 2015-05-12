package com.renho.e38;

import com.renho.e38.Person.Home;


/**
 *
 * @author Phenix
 * 2011-3-21
 */
public class Client {
	public static void main(String[] args) {
		//定义张三这个人
		Person p = new Person("张三");
		//设置张三的家庭信息
		p.setHome(new Home("上海","021"));
	}
}


