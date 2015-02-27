package j2setest.effective.e2;

public class Car {

	private String color;
	private int height;
	private int width;
	private String ownerName;
	
	public static class Builder{
		private String color;
		private int height;
		private int width;
		private String ownerName;
		public Builder() {
			
		}
		public Builder color(String color) {
			this.color = color;
			return this;
		}
		public Builder height(int height) {
			this.height = height;
			return this;
		}
		public Builder width(int width) {
			this.width = width;
			return this;
		}
		public Builder ownerName(String ownerName) {
			this.ownerName = ownerName;
			return this;
		}
		public Car build() {
			return new Car(this);
		}
	}
	
	private Car(Builder builder) {
		this.color = builder.color;
		this.height = builder.height;
		this.width = builder.width;
		this.ownerName = builder.ownerName;
	}
	
	public void print() {
		System.out.println("color:" + this.color + "-height:" + this.height + "-width:" + this.width + "-ownerName:" + this.ownerName);
	}
}
