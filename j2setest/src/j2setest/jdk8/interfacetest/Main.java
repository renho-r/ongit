package j2setest.jdk8.interfacetest;

public class Main {

	public static void main(String[] args) {
		InterfaceTest it = new InterfaceTest() {
			@Override
			public void print() {
				System.out.println("print");
			}
		};
		System.out.println(it.get(""));
		it.print();
	}

}
