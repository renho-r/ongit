package com.renho.behavior.visitor.manandwoman;

import com.renho.behavior.visitor.manandwoman.person.Man;
import com.renho.behavior.visitor.manandwoman.person.Woman;

public interface Visitor {

	public void getManStatus(Man man);
	public void getWomanStatus(Woman woman);

}
