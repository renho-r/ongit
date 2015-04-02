package com.renho.behavior.interpret;

public class TerminalExpression extends AbstractExpression {

	@Override
	public void interpret(Context context) {
		System.out.println("terminal expression:" + context.getInput());
	}

}
