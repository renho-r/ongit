package j2setest.test;

public class AllSuper<T> {

	public void exe(T t) {
		System.out.println(t.getClass());
	}
	
	public <U> void action(U u) {
		System.out.println(u.getClass());
	}
}
