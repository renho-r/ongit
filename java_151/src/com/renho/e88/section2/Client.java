package com.renho.e88.section2;

public class Client {
	public static void main(String[] args) {
		// ��������
		Car car = CarFactory.BuickCar.create();
	}
}

interface Car {
};

class FordCar implements Car {
};

class BuickCar implements Car {
};

enum CarFactory {
	// ���幤��������������������
	FordCar, BuickCar;
	// ��������
	public Car create() {
		switch (this) {
		case FordCar:
			return new FordCar();
		case BuickCar:
			return new BuickCar();
		default:
			throw new AssertionError("��Ч����");
		}
	}
}