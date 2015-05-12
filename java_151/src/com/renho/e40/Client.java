package com.renho.e40;

public class Client {
	public static void main(String[] args) {
		Calculator c1 = new Calculator(1, 2) {
			{
				setOperator(Ops.ADD);
			}
		};

		Calculator c2 = new Add(1, 2);
		System.out.println(c1.getResult());
		System.out.println(c2.getResult());

	}

}

// ����һ��ö�٣��޶�������
enum Ops {
	ADD, SUB
}

class Calculator {
	private int i, j, result;

	// �޲ι���
	public Calculator() {
	}

	// �вι���
	public Calculator(int _i, int _j) {
		i = _i;
		j = _j;
	}

	// ���÷��ţ��Ǽӷ����㻹�Ǽ�������
	protected void setOperator(Ops _op) {
		result = _op.equals(Ops.ADD) ? i + j : i - j;
	}

	// ȡ��������
	public int getResult() {
		return result;
	}
}

// �ӷ�����
class Add extends Calculator {
	{
		setOperator(Ops.ADD);
	}

	// ��д����Ĺ��췽��
	public Add(int _i, int _j) {
		super(_i, _j);
	}
}