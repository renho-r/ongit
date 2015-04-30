package com.renho.dynamic._test;

import com.renho.dynamic.start.DynamicStart;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		DynamicStart dynamicStart = new DynamicStart();
		String classLoaderId = dynamicStart.loadClass(new String[]{"com.renho.dynamic.business._test.TestInterfaceImpl", "com.renho.dynamic.business._test.Test0"});
		dynamicStart.start("com.renho.dynamic.business._test.TestInterfaceImpl", classLoaderId);
		Thread.sleep(10000);
		
		classLoaderId = dynamicStart.loadClass(new String[]{"com.renho.dynamic.business._test.TestInterfaceImpl", "com.renho.dynamic.business._test.Test0"});
		dynamicStart.reStart("com.renho.dynamic.business._test.TestInterfaceImpl", classLoaderId);
	}

}
