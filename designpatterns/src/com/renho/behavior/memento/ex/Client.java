package com.renho.behavior.memento.ex;

public class Client {
	private static Originator o = new Originator();
	private static Caretaker c = new Caretaker();

	public static void main(String[] args) {
		o.setState("on");
		// 调用发起人角色的createMemento()方法，
		//创建一个备忘录对象将这个状态存储起来。将备忘录对象存储到负责人对象中去。这样负责人并不知道具体的备忘录，而只知道是MementoIF类型，这就是窄接口。
		c.saveMemento(o.createMemento());

		o.setState("Off");
		// 将备忘录对象从负责人对象中取出。将发起人对象的状态恢复成备忘录对象所存储起来的状态，即”On”状态。
		o.restoreMemento(c.retrieveMemento());
	}
}
