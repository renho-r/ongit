package j2setest;

public class TestFinally {

	public static int test() {
		try{
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("21332");
		}
		return 1;
	}
	
	public static void main(String[] args) {
		System.out.println(test());
	}
	
}
