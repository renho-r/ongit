package com.renho;

public class ReceiveImpl implements Receive {

	@Override
	public String sendXML(String text) {
		System.out.println("��ʼ����sendXML�ӿ�");
		System.out.println(text);
		return "Renho" + text;
	}

}
