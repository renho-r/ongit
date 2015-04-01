package com.renho.behavior.state;

public class ConcreteStateC extends State{

	private int status;
	
	public ConcreteStateC(int status) {
		this.status = status;
	}
	
	@Override
	public void handle(Context context) {
		if(this.status >= 24) {
			System.out.println("已经休息:" + status);	
		}else {
			System.out.println("晚上:" + status);			
			status = status + 6;
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
