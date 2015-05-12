package duckpack;

import birdpack.Bird;

public class Duck1 extends Bird {
	public void setn(int duck1n) {
		// 在子类中直接访问父类中的protected变量
		nFeathers = duck1n;
	}
}