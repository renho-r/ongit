package com.renho.behavior.visitor.manandwoman.visitor;

import com.renho.behavior.visitor.manandwoman.Visitor;
import com.renho.behavior.visitor.manandwoman.person.Man;
import com.renho.behavior.visitor.manandwoman.person.Woman;

public class SuccessVisitor implements Visitor {

	@Override
	public void getManStatus(Man man) {
		System.out.println("���˳ɹ�ʱ:ʲôʲô");
	}

	@Override
	public void getWomanStatus(Woman woman) {
		System.out.println("Ů�˳ɹ�ʱ:ʲôʲô");
	}

}
