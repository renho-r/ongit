package com.renho;

public class ReceiveImpl implements Receive {

	@Override
	public String sendXML(String text) {
		System.out.println("开始调用sendXML接口");
		System.out.println(text);
		return "Renho" + text;
	}

}
