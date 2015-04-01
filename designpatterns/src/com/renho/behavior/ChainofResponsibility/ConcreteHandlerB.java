package com.renho.behavior.ChainofResponsibility;

public class ConcreteHandlerB extends Handler {

	@Override
	public void handleRequest(int request) {
		System.out.println("ConcreteHandlerB:" + request);
		if(request > 2) {
			System.out.println("无法处理,向上请求!");
			this.successor.handleRequest(request);			
		}else {
			System.out.println("ConcreteHandlerB:结束");
		}
	}

}
