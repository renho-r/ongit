package com.renho.behavior.visitor;

public interface Element {
	
	void Accept(Visitor visitor);
}
