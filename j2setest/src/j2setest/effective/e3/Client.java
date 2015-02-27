package j2setest.effective.e3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client {

	public static void main(String[] args) throws SecurityException, ClassNotFoundException{
		Singlent singlent1 = Singlent.getInstance();
		singlent1.print();
		Singlent singlent2 = Singlent.getInstance();
		System.out.println(singlent1 == singlent2);
		Constructor<Singlent>[] constructors = null;
		constructors = (Constructor<Singlent>[]) Class.forName("j2setest.effective.e3.Singlent").getDeclaredConstructors();
		Constructor<Singlent> con = constructors[0];
		con.setAccessible(true);
		Singlent singlent3;
		try {
			singlent3 = con.newInstance(null);
			singlent3.print();
			System.out.println(singlent1 == singlent3);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			System.out.println(11);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.out.println(22);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.println(33);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.out.println(44);
			e.printStackTrace();
		}
		
	}

}
