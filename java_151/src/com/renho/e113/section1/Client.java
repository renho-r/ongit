package com.renho.e113.section1;

import java.util.zip.DataFormatException;

public class Client {
	public static void main(String[] args) {
		try {
			doStuff(-1);
			doStuff(100);
		} catch (Exception e) {
			System.out.println("��������Զ�����ᵽ���");
		}
	}

	public static int doStuff(int _p) throws Exception {
		try {
			if (_p < 0) {
				throw new DataFormatException("���ݸ�ʽ����");
			} else {
				return _p;
			}
		} catch (Exception e) {
			// �쳣����
			throw e;
		} finally {
			return -1;
		}
	}
}
