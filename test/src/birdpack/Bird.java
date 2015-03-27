package birdpack;

public class Bird {
	protected int nFeathers;
	
	protected void get() {
		Bird bird = new Bird();
		bird.nFeathers = 10;
		System.out.println("Bird");
	}
}