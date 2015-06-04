package com.renho.create.factory.exoperation;

import java.math.BigDecimal;
import java.util.Scanner;

public class Client {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		OperationFactory operationFactory = new OperationFactory();
		Scanner scanner = new Scanner(System.in);
		double d0 = scanner.nextDouble();
		String oper = scanner.next();
		double d1 = scanner.nextDouble();
		
		IOperation iOperation = operationFactory.getOperation(oper);
		iOperation.setB0(new BigDecimal(d0));
		iOperation.setB1(new BigDecimal(d1));
		
		System.out.println(iOperation.operation());
	}

}
