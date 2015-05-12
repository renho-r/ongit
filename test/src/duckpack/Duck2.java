package duckpack;

import birdpack.Bird;

public class Duck2 extends Bird {

	public void construct(int newduck2) {
		Duck2 d2 = new Duck2();
		// 在子类中通过子类的对象访问父类中的protected变量
		d2.nFeathers = newduck2;
		d2.get();
		
		Bird d = new Duck2();
		d.nFeathers = newduck2;// (编译错误)
		d.get();
		// 父类引用指向之类对象是无法调用protected变量的。
	}
}