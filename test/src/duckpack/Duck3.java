package duckpack;

import birdpack.Bird;

public class Duck3 extends Bird {

	public void construct(int newduck3) {
		Bird b = new Bird();
		// �������ø�����󷴶����ܷ��ʸ����е�protected����
		b.nFeathers = newduck3;
		b.get();
	}
}