package com.renho.create.factory.exoperation.impl;

import java.math.BigDecimal;

import com.renho.create.factory.exoperation.IOperation;

public class OperationDiv extends IOperation {

	@Override
	public BigDecimal operation() {
		return this.getB0().divide(this.getB1());
	}

}
