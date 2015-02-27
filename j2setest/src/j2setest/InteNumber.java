package j2setest;

public class InteNumber implements Cloneable{
	
	public int i;
	
	public Obj obj = new Obj();

	public InteNumber clone() {
		InteNumber objTemp = null;
		try {
			objTemp = (InteNumber) super.clone();
			objTemp.obj = this.obj.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objTemp;
	}
	
}
