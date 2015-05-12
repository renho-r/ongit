package com.renho.behavior.memento.ex;

public class Client {
	private static Originator o = new Originator();
	private static Caretaker c = new Caretaker();

	public static void main(String[] args) {
		o.setState("on");
		// ���÷����˽�ɫ��createMemento()������
		//����һ������¼�������״̬�洢������������¼����洢�������˶�����ȥ�����������˲���֪������ı���¼����ֻ֪����MementoIF���ͣ������խ�ӿڡ�
		c.saveMemento(o.createMemento());

		o.setState("Off");
		// ������¼����Ӹ����˶�����ȡ�����������˶����״̬�ָ��ɱ���¼�������洢������״̬������On��״̬��
		o.restoreMemento(c.retrieveMemento());
	}
}
