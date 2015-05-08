package j2setest.ibmdev.volatiletest.test0;

public class Client{

	public static NumberRange numberRange = new NumberRange();
	
	public static void main(String[] args) {
		
		Test t = new Test();
		t.setNumberRange(numberRange);
		Thread thread = new Thread(t);
		thread.start();
		
		numberRange.setLower(4);
	}
}

class Test implements Runnable {

	private NumberRange numberRange = null;
	
	public NumberRange getNumberRange() {
		return numberRange;
	}

	public void setNumberRange(NumberRange numberRange) {
		this.numberRange = numberRange;
	}

	@Override
	public void run() {
		numberRange.setUpper(3);
	}
	
}