package com.renho.e84.section2;

public class Client {

}

enum Role {

	Admin("����Ա", new Lifetime(), new Scope()), User("��ͨ�û�", new Lifetime(),
			new Scope());

	// ����
	private String name;
	// ��ɫ��������
	private Lifetime lifeTime;
	// Ȩ�޷�Χ
	private Scope scope;

	Role(String _name, Lifetime _lt, Scope _scope) {
		name = _name;
		lifeTime = _lt;
		scope = _scope;
	}

	// ��ɫ����
	public String getName() {
		return name;
	}

	// ��ý�ɫ��������
	public Lifetime getLifetime() {
		return lifeTime;
	}

	// ���Ȩ�޷�Χ
	public Scope getScope() {
		return scope;
	}
}

class Lifetime {
}

class Scope {
}