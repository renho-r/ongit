package com.renho.cglib.aop;

public class Client {

	public static void main(String[] args) {
		
		RealService realService = AopUtils.newInstance(RealService.class);
		boolean flag = realService.save("renho");
		System.out.println(flag);
		System.out.println("------------------------------");
		System.out.println(realService.list());
		System.out.println("------------------------------");
		realService.get();
	}

}
