package com.renho.behavior.ChainofResponsibility;

public class ConcreteHandlerB extends Handler {

	@Override
	public void handleRequest(int request) {
		System.out.println("ConcreteHandlerB:" + request);
		if(request > 2) {
			System.out.println("�޷�����,��������!");
			this.successor.handleRequest(request);			
		}else {
			System.out.println("ConcreteHandlerB:����");
		}
	}

}
