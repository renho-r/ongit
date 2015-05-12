package com.renho.behavior.state;

public class ConcreteStateA extends State{

	private int status;
	
	public ConcreteStateA(int status) {
		this.status = status;
	}
	
	@Override
	public void handle(Context context) {
		context.setState(new ConcreteStateB(status + 6));
		System.out.println("ÉÏÎç:" + status);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
