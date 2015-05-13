package com.renho.e88.section1;

public class Client {
	public static void main(String[] args) {
		// ��������
		Car car = CarFactory.createCar(Car.class);
	}
}

// �����Ʒ
interface Car {
};

// �����Ʒ��
class FordCar implements Car {
};

// �����Ʒ��
class BuickCar implements Car {
};

// ������
class CarFactory {
	// ��������
	public static Car createCar(Class<? extends Car> c) {
		try {
			return (Car) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
