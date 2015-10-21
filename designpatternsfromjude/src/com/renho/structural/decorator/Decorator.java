package com.renho.structural.decorator;

public class Decorator extends Component {

	private Component component;

	public Decorator() {}
	
	public Decorator(Component component) {
		this.component = component;
	}

	public void operation() {
		this.component.operation();
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}
}
