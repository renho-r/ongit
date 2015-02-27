package com.renho.behavior.command;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Waiter waiter = new Waiter();
		Receiver receiver = new Receiver();
		ICommand iCommand = new ConcreteCommand(receiver);
		ICommand iCommand1 = new ConcreteCommand1(receiver);
		waiter.addCommand(iCommand);
		waiter.addCommand(iCommand1);
		waiter.exeNotify();
	}

}
