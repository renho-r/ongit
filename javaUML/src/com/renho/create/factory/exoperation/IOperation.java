package com.renho.create.factory.exoperation;

import java.math.BigDecimal;

public abstract class IOperation {
	
	private BigDecimal b0;
	private BigDecimal b1;
	
	
	public abstract BigDecimal operation();
	
	public BigDecimal getB0() {
		return b0;
	}

	public void setB0(BigDecimal b0) {
		this.b0 = b0;
	}

	public BigDecimal getB1() {
		return b1;
	}

	public void setB1(BigDecimal b1) {
		this.b1 = b1;
	}
	
}
