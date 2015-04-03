package com.renho.behavior.interpret;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		Context context = new Context();
		context.setInput("renho");
		
		List<AbstractExpression> list = new ArrayList<AbstractExpression>();
		list.add(new TerminalExpression());
		list.add(new TerminalExpression());
		list.add(new TerminalExpression());
		list.add(new NonterminalExpression());
		
		for(AbstractExpression ae:list) {
			ae.interpret(context);
		}
	}

}
