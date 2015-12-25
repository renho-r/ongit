package com.renho.behavior.visitor.manandwoman;

import com.renho.behavior.visitor.manandwoman.person.Man;
import com.renho.behavior.visitor.manandwoman.person.Woman;
import com.renho.behavior.visitor.manandwoman.visitor.FailingVisitor;
import com.renho.behavior.visitor.manandwoman.visitor.SuccessVisitor;

public class Client {

	public static void main(String[] args) {
		ObjectStructure os = new ObjectStructure();
		os.add(new SuccessVisitor());
		os.add(new FailingVisitor());
		
		Person man = new Man();
		Person woman = new Woman();
		
		os.display(man);
		os.display(woman);
	}

}
