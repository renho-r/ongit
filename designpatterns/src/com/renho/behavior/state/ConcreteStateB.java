package com.renho.behavior.state;

public class ConcreteStateB extends State{

private int status;
	
	public ConcreteStateB(int status) {
		this.status = status;
	}
	
	@Override
	public void handle(Context context) {
		context.setState(new ConcreteStateC(status + 6));
		System.out.println("ÖÐÎç:" + status);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
