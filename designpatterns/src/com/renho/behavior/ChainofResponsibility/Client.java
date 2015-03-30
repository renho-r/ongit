package com.renho.behavior.ChainofResponsibility;

public class Client {

	public static void main(String[] args) {
		Handler handlerA = new ConcreteHandlerA();
		Handler handlerB = new ConcreteHandlerB();
		Handler handlerC = new ConcreteHandlerC();
		
		handlerA.setSuccessor(handlerB);
		handlerB.setSuccessor(handlerC);
		
		for(int i=0; i<10; i++) {
			handlerA.handleRequest(i);
			System.out.println("--------------------><-------------------");
		}
	}

}
