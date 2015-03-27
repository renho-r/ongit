package duckpack;

import birdpack.Bird;

public class Duck3 extends Bird {

	public void construct(int newduck3) {
		Bird b = new Bird();
		// 子类中用父类对象反而不能访问父类中的protected变量
		b.nFeathers = newduck3;
		b.get();
	}
}