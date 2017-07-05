package com.renho.returnexception;

public class Client {

	public static void main(String[] args) {
		Client m = new Client();
		String b = m.getName();
		System.out.println("name:" + b);
	}
	
	public String getName() {
		try {
			int i = 100/0;
			return "try";
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
//			return "catch";
		} finally {
//			return "finally";
		}
//		return null;
	}
	
}
