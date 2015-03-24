package j2setest.jdk8.interfacetest;

public interface InterfaceTest {

	void print();
	
	default String get(String s) {
		return "renho";
	}
}
