package j2setest;

public class OuterClass {

	private int i = 0;
	
	public class InnerClass extends Abstracte {
		private int i = 0;
		public InnerClass(int i) {
			this.i = i;
		}
		public void test(){
			System.out.println("Test InnerClass" + " : " + this.i);
			System.out.println("Test OuterClass" + " : " + OuterClass.this);
			System.out.println("Test OuterClass" + " : " + OuterClass.this.i);
		}
	}
	
	public static class InnerClass2 {
		public static int i = 0;
		public static Abstracte test() {
			System.out.println("Test InnerClass2" + " : " + i);
			return new Abstracte() {
				private int i = 11;
				@Override
				public void test() {
					System.out.println(i);
				}
			};
		}
	}
	
	public static void main(String[] args) {
		InnerClass innerClass = new OuterClass().new InnerClass(1);
		innerClass.test();
		OuterClass outerClass = new OuterClass();
		innerClass = outerClass.new InnerClass(2);
		innerClass.test();
		OuterClass.InnerClass2.test().test();
		Abstracte a = outerClass.new InnerClass(2);
		a.test();
	}

}
