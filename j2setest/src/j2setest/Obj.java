package j2setest;

public class Obj implements Cloneable{

	public int i = 10;
	
	public void change() {
		this.i = 10 + 5;
	}
	
	public Obj clone() {
		Obj obj = null;
		
		try {
			obj = (Obj) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
