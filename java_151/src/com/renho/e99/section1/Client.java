package com.renho.e99.section1;

public class Client {
	// ���ʵ���2500Ԫ���ϰ��岢��վ���ĳ˿ͳ�Ʊ��8��
	public static <T extends Staff & Passenger> void discount(T t) {
		if (t.getSalary() < 2500 && t.isStanding()) {
			System.out.println("��ϲ�㣡���ĳ�Ʊ����ۣ�");
		}
	}

	public static void main(String[] args) {
		discount(new Me());
	}

}

// ְԱ
interface Staff {
	// ����
	public int getSalary();
}

// �˿�
interface Passenger {
	// �Ƿ���վ��״̬
	public boolean isStanding();
}

class Me implements Staff, Passenger {
	public boolean isStanding() {
		return true;
	}

	public int getSalary() {
		return 2000;
	}
}
