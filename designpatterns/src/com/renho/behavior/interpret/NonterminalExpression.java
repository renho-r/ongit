package com.renho.behavior.interpret;

public class NonterminalExpression extends AbstractExpression {

	@Override
	public void interpret(Context context) {
		System.out.println("nonterminal expression:" + context.getInput());
	}

}
