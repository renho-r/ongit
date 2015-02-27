package j2setest.effective.e3;

public class Singlent {

	private static Singlent singlent;
	private static int i = 0;
	private Singlent() throws Exception {
		if(i != 0) {
			throw new Exception("���ܶ��δ���ʵ��");
		}else {
			i--;
		}
	}
	
	public synchronized static Singlent getInstance() {
		if(null == singlent) {
			try {
				singlent = new Singlent();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singlent;
	}
	
	public void print() {
		System.out.println("singlent:" + this);
	}
}
