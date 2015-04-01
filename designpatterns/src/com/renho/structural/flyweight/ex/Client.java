package com.renho.structural.flyweight.ex;

public class Client {
	public static void main(String[] args) {
		WebSite wb1 = WebSiteFactory.createWebSite("BusinessWebSite");
		User user1 = new User("root", "root");
		wb1.use(user1);

		WebSite wb2 = WebSiteFactory.createWebSite("BusinessWebSite");
		User user2 = new User("admin", "admin");
		wb2.use(user2);

		WebSite wb3 = WebSiteFactory.createWebSite("BusinessWebSite");
		User user3 = new User("slave", "slave");
		wb3.use(user3);

		WebSite wb4 = WebSiteFactory.createWebSite("PersonalWebSite");
		User user4 = new User("person", "person");
		wb4.use(user4);

		WebSite wb5 = WebSiteFactory.createWebSite("PersonalWebSite");
		User user5 = new User("alexis", "alexis");
		wb5.use(user5);

		WebSite wb6 = WebSiteFactory.createWebSite("PersonalWebSite");
		User user6 = new User("shadow", "shadow");
		wb6.use(user6);

		System.out.println("WebSites Instances Count: " + WebSiteFactory.webSitesCount());
	}
}
