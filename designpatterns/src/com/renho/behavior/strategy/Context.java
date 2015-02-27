package com.renho.behavior.strategy;

public class Context {

	private IStrategy iStrategy;
	private String para;
	
	public Context(IStrategy iStrategy) {
		this.iStrategy = iStrategy;
	}
	
	public Context(IStrategy iStrategy, String para) {
		this.iStrategy = iStrategy;
		this.para = para;
	}
	
	public void behavior() {
		this.iStrategy.behavior(this);
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}
	
}
