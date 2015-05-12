package com.renho.structural.flyweight.ex;

public class ConcurrentWebSite extends WebSite {
	public ConcurrentWebSite(String type) {
		super(type);
	}

	@Override
	public void use(User user) {
		System.out.println("The web site's type is: " + type);
		System.out.println("User: " + user.getUserName());
		System.out.println("Passwd: " + user.getPassWd());
		System.out.println();
	}
}
