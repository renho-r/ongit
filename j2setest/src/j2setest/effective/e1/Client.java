package j2setest.effective.e1;

public class Client {

	public static void main(String[] args) {
//		StaticNewInstance snt = StaticNewInstance.getInstance();
//		System.out.println(snt);
		char l[] = {49,48,75,61,75,80,82,52,37,78,23,65,76,43,30,76,6,62,21,75,60,56,53,60,66,45,48,48,95,74,74};
		for(int i=0; i<l.length; i++) {
			l[i] *= -1;
			System.out.println(l[i]);
		}
		System.out.println(l);
	}

}
