package com.renho.e44;

import java.io.Serializable;

public class Client {
	public static void main(String[] args) {
		// ���常��
		Person f = new Person("����");
		// ��������
		Person s1 = new Person("�����", f);
		s1.setName("�����");

		// С���ӵ���Ϣ��ͨ������ӿ�¡������
		Person s2 = CloneUtils.clone(s1);

		s2.setName("С����");
		s1.getFather().setName("�ɵ�");
		System.out.println(s1.getName() + " �ĸ����� " + s1.getFather().getName());
		System.out.println(s2.getName() + " �ĸ����� " + s2.getFather().getName());
	}
}

class Person implements Serializable {
	private static final long serialVersionUID = 1611293231L;
	// ����
	private String name;
	// ����
	private Person father;

	public Person(String _name) {
		name = _name;
	}

	public Person(String _name, Person _parent) {
		name = _name;
		father = _parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}
}
