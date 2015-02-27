package j2setest.effective.e11;

public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {
		SubClass subClass = new SubClass();
		subClass.i = 100;
		SubClass subClass2 = (SubClass) subClass.clone();
		System.out.println(subClass2.i);
	}

}
