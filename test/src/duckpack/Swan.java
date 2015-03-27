package duckpack;

import birdpack.Bird;

public class Swan extends Bird {

	public void construct(int swan) {
		Duck1 d1 = new Duck1();
		// 子类中用另外一个子类的对象也不能访问父类中的protected变量
		d1.nFeathers = swan;
		d1.get();
	}
}