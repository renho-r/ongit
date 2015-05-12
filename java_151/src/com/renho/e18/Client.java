package com.renho.e18;

import java.util.Date;

/**
 * ����instanceof��Ԥ�ڽ��
 */
@SuppressWarnings("all")
public class Client {	
	public static void main(String[] args) {
		//String�����Ƿ���Object��ʵ��
		boolean b1 = "Sting" instanceof Object;
		//String�����Ƿ���String��ʵ��
		boolean b2 = new String() instanceof String;
		//Object�����Ƿ���String��ʵ��
		boolean b3 = new Object() instanceof String;
		//���������Ƿ���װ�����͵�ʵ��
	//	boolean b4 = 'A' instanceof Character;
		//�ն����Ƿ���String��ʵ��
		boolean b5 = null instanceof String;
		//����ת����Ŀն����Ƿ���String��ʵ��
		boolean b6 = (String)null instanceof String;
		//Date�����Ƿ���String��ʵ��
	//	boolean b7 = new Date() instanceof String;
		//�ڷ��������ж�String�����Ƿ���Date��ʵ��
		boolean b8 = new GenericClass<String>().isDateInstance("");
		

	}
}

class GenericClass<T>{
	//�ж��Ƿ���Date����
	public boolean isDateInstance(T t){
		return t instanceof Date;
	}
}

