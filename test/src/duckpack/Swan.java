package duckpack;

import birdpack.Bird;

public class Swan extends Bird {

	public void construct(int swan) {
		Duck1 d1 = new Duck1();
		// ������������һ������Ķ���Ҳ���ܷ��ʸ����е�protected����
		d1.nFeathers = swan;
		d1.get();
	}
}