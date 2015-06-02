package com.renho;

import java.lang.reflect.Method;
import java.util.TimerTask;

public class MyTimeTask extends TimerTask {

	@Override
	public void run() {
		try {
			// ÿ�ζ�������һ���µ��������
			HotswapCL cl = new HotswapCL("E:/renho/workspace/ongit/updateOnLine/swap", new String[] { "com.renho.Foo" });
			Class<?> cls = cl.loadClass("com.renho.Foo");
			Object foo = cls.newInstance();

			Method m = foo.getClass().getMethod("sayHello", new Class[] {});
			m.invoke(foo, new Object[] {});
			System.out.println(foo.getClass().getClassLoader());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
