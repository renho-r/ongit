package j2setest.effective.e2;

public class Client {

	public static void main(String[] args) {
		Car car = new Car.Builder().color("blue").height(2).width(2).ownerName("renho").build();
		car.print();
	}

}
