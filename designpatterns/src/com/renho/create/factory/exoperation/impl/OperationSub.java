package com.renho.create.factory.exoperation.impl;

import java.math.BigDecimal;

import com.renho.create.factory.exoperation.IOperation;

public class OperationSub extends IOperation {

	@Override
	public BigDecimal operation() {
		return this.getB0().subtract(this.getB1());
	}

}
