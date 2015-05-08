package j2setest.ibmdev.volatiletest.test0;

public class NumberRange {
	private int lower = 0, upper = 5;

	public int getLower() {
		return lower;
	}

	public int getUpper() {
		return upper;
	}

	public void setLower(int value) {
		System.out.println("in setLower");
        if (value > upper) 
            throw new IllegalArgumentException("renho setLower");
        lower = value;
        try {
        	Thread.sleep(1000);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        System.out.println("out setLower");
        System.out.println("setLower" + lower + ":" + upper);
    }

	public void setUpper(int value) {
		System.out.println("in setUpper");
        if (value < lower) 
            throw new IllegalArgumentException("renho setUpper");
        upper = value;
        try {
        	Thread.sleep(1000);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        System.out.println("out setUpper");
        System.out.println("setUpper" + lower + ":" + upper);
    }
}