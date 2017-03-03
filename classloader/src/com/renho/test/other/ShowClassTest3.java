package com.renho.test.other;

import com.renho.test.MyClassLoader;
import com.renho.test.SuperTest;

public class ShowClassTest3 implements Runnable {

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		while(true) {
			Class<?> clazz;
			try {
				System.out.println(MyClassLoader.myLoader);
				clazz = MyClassLoader.myLoader.classMap.get("com.renho.test.Test3");
				SuperTest s = (SuperTest) clazz.newInstance();
				System.out.print("ShowClassTest3----------->");
				s.renho();
				Thread.sleep(500);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
