package com.renho;

public class UserDAOImpl {

	public boolean saveUser(User user) {
		Throwable t = new Throwable();
		StackTraceElement[] stes = t.getStackTrace();
		for(StackTraceElement ste:stes) {
			System.out.println(ste);
		}
		return true;
	}
	
}
