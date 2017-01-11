package com.renho.behavior.visitor.manandwoman.visitor;

import com.renho.behavior.visitor.manandwoman.Visitor;
import com.renho.behavior.visitor.manandwoman.person.Man;
import com.renho.behavior.visitor.manandwoman.person.Woman;

public class SuccessVisitor implements Visitor {

	@Override
	public void getManStatus(Man man) {
		System.out.println("男人成功时:什么什么");
	}

	@Override
	public void getWomanStatus(Woman woman) {
		System.out.println("女人成功时:什么什么");
	}

}
