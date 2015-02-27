package j2setest.effective.e11;

public class SubClass extends SuperClass implements Cloneable {

	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
