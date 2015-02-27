package j2setest.init;

class Base {
	public static int a = 10;
	public int b = 20;
	static{
		System.out.println("Static Init Base " + a);
	}

	public Base(){
		System.out.println("Init Base " + this.b);
	}
}

/**
 * һ������ͻ������������һ��
 **/
class SuperClass extends Base {
	public static int a1 = getSuperStaticNumber();
	public int b1 = getSuperInstanceNumber();
	public SuperClass(){
		System.out.println("Init SuperClass" + this.b1);
	}

	static{

		System.out.println("Static Init SuperClass" + a1);

	}

	public static int getSuperStaticNumber() {
		System.out.println("Static member init");
		return 100;
	}

	public int getSuperInstanceNumber(){

		System.out.println("Instance member init");
		return 200;

	}
}

/**
 * ��������Ϊ���Ըô����������
 */
public class SubClass extends SuperClass {
	public static int a2 = getStaticNumber();

	public int b2 = getInstanceNumber();

	public SubClass(){
		System.out.println("Init SubClass " + this.b2);

	}

	public static int getStaticNumber(){

		System.out.println("Static member init Sub");

		return 1000;

	}

	public int getInstanceNumber(){

		System.out.println("Instance member init Sub");

		return 2000;

	}

	public static void main(String args[]){

		new SubClass();

	}

	static{
		System.out.println("Static Init " + a2);
	}

}