package com.renho.behavior.ChainofResponsibility;

public class ConcreteHandlerA extends Handler {

	@Override
	public void handleRequest(int request) {
		System.out.println("ConcreteHandlerA:" + request);
		if(request > 1) {
			System.out.println("�޷�����,��������!");
			this.successor.handleRequest(request);			
		}else {
			System.out.println("ConcreteHandlerA:����");
		}
	}

}
