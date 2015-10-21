package com.renho.create.factory.simplefactory;

public class Factory {
	public Product getProduct(String productType) {
		Product product = null;
		if("A".equals(productType.toUpperCase())) {
			product = new ProductA();
		}else if("B".equals(productType.toUpperCase())) {
			product = new ProductB();
		}else if("C".equals(productType.toUpperCase())) {
			product = new ProductC();
		}
		return product;
	}
	 
}
 
