package com.renho.behavior.ChainofResponsibility;

public class ConcreteHandlerC extends Handler {

	@Override
	public void handleRequest(int request) {
		if(request > 5) {
			System.out.println("²»ÔÊĞí");	
		}else {
			System.out.println("ConcreteHandlerC:½áÊø");			
		}
	}

}
