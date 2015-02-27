package j2setest.test;

public class MyType {

	private int i = 0;
	
	public MyType(int i) {
		this.i = i;
	}
	
	public String toString() {
		return this.getClass() + ":" + i;
	}
	
}
