package com.renho.behavior.command;

public class ConcreteCommand1 implements ICommand {

private Receiver receiver;
	
	public ConcreteCommand1() {}
	
	public ConcreteCommand1(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.action2();
	}

}
