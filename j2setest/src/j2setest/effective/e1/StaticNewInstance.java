package j2setest.effective.e1;

public class StaticNewInstance {

	public static StaticNewInstance getInstance() {
		return new StaticNewInstance();
	}
	
	public String toString() {
		return "StaticNewInstance";
	}
	
}
