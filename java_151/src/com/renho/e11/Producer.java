package com.renho.e11;
/**
 * ��Ϣ�������ߣ�Ҳ�������л���
 *
 */
public class Producer {
	public static void main(String[] args) throws Exception {
		Person person = new Person();
		person.setName("����ħ��"); 
		//���л������浽������
		SerializationUtils.writeObject(person);
	}
}


