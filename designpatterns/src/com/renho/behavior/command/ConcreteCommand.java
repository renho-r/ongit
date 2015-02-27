package com.renho.behavior.command;

public class ConcreteCommand implements ICommand {
	
	private Receiver receiver;
	
	public ConcreteCommand() {}
	
	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.action1();
	}

}
