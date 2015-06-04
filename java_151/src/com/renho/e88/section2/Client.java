package com.renho.e88.section2;

public class Client {
	public static void main(String[] args) {
		// 生产汽车
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
	// 定义工厂类能生产汽车的类型
	FordCar, BuickCar;
	// 生产汽车
	public Car create() {
		switch (this) {
		case FordCar:
			return new FordCar();
		case BuickCar:
			return new BuickCar();
		default:
			throw new AssertionError("无效参数");
		}
	}
}