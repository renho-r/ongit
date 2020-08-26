package com.renho.bean.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

	private String name;
<<<<<<< HEAD
	private String address;
	private int phone;
	private Cat cat;
	private BeanFactory beanFactory;
	private String beanName;

	@Value("${renho: 'ttt'}")
	private String renho;
=======
	private String password;
>>>>>>> 4ccc284a86f8313770f03de4d90a746fb9a76e4b

	public Person() {
		System.out.println("【构造器】调用Person的构造器实例化");
	}

<<<<<<< HEAD
	public String getRenho() {
		return renho;
	}

	public void setRenho(String renho) {
		this.renho = renho;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		System.out.println("【注入属性】注入属性cat");
		this.cat = cat;
=======
	public Person(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getPersonName() {
		return "personName:renho";
>>>>>>> 4ccc284a86f8313770f03de4d90a746fb9a76e4b
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("【注入属性】注入属性name");
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		System.out.println("【注入属性】注入属性address");
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		System.out.println("【注入属性】注入属性phone");
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [address=" + address + ", name=" + name + ", phone=" + phone + ", renho=" + renho + "]";
	}

	// 这是BeanFactoryAware接口方法
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
		this.beanFactory = arg0;
	}

	// 这是BeanNameAware接口方法
	@Override
	public void setBeanName(String arg0) {
		System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
		this.beanName = arg0;
	}

	// 这是InitializingBean接口方法
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
	}

	// 这是DiposibleBean接口方法
	@Override
	public void destroy() throws Exception {
		System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
	}

	// 通过<bean>的init-method属性指定的初始化方法
	public void myInit() {
		System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
	}

	// 通过<bean>的destroy-method属性指定的初始化方法
	public void myDestory() {
		System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
	}
}