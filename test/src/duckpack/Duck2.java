package duckpack;

import birdpack.Bird;

public class Duck2 extends Bird {

	public void construct(int newduck2) {
		Duck2 d2 = new Duck2();
		// ��������ͨ������Ķ�����ʸ����е�protected����
		d2.nFeathers = newduck2;
		d2.get();
		
		Bird d = new Duck2();
		d.nFeathers = newduck2;// (�������)
		d.get();
		// ��������ָ��֮��������޷�����protected�����ġ�
	}
}