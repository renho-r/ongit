package com.renho.test.factorymethod;

public class LoginAction {

	private Logic logic;
	private LoginAction(Logic logic) {
		this.logic = logic;
	}

	public static LoginAction createInstance(Logic logic) {
		LoginAction loginAction = new LoginAction(logic);
		return loginAction;
	}

	public void execute() {
		String name = logic.getName();
		System.out.print("My Name Is " + name);
	}
}