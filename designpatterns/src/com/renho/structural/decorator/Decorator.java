package com.renho.structural.decorator;

public class Decorator implements Component {

	private Component component;
	
	public Decorator() {}
	
	public Decorator(Component component) {
		this.component = component;
	}
	
	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	@Override
	public void operation() {
		this.component.operation();
	}

}
