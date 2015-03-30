package com.renho.behavior.ChainofResponsibility;

public class ConcreteHandlerA extends Handler {

	@Override
	public void handleRequest(int request) {
		System.out.println("ConcreteHandlerA:" + request);
		if(request > 1) {
			System.out.println("无法处理,向上请求!");
			this.successor.handleRequest(request);			
		}else {
			System.out.println("ConcreteHandlerA:结束");
		}
	}

}
