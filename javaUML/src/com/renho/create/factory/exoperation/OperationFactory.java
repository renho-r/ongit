package com.renho.create.factory.exoperation;

import com.renho.create.factory.exoperation.impl.OperationDiv;
import com.renho.create.factory.exoperation.impl.OperationMul;
import com.renho.create.factory.exoperation.impl.OperationPlus;
import com.renho.create.factory.exoperation.impl.OperationSub;

public class OperationFactory {

	public IOperation getOperation(String oper) {
		IOperation iOperation = null;
		switch (oper) {
			case "+":
				iOperation = new OperationPlus();
				break;
			case "-":
				iOperation = new OperationSub();
				break;
			case "*":
				iOperation = new OperationMul();
				break;
			case "/":
				iOperation = new OperationDiv();
				break;
			default:
				break;
		}
		return iOperation;
	}
}
