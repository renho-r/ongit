package com.renho.e25;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Client {
	public static void main(String[] args) {
		//���
		BigDecimal d = new BigDecimal(888888);
		//�����ʣ���3���㼾����
		BigDecimal r = new BigDecimal(0.001875*3);
		//������Ϣ
		BigDecimal i = d.multiply(r).setScale(2,RoundingMode.HALF_EVEN);		
		System.out.println("����Ϣ�ǣ�"+i);
		
		BigDecimal b = new BigDecimal(2.51);
		System.out.println(b.setScale(1,RoundingMode.UP));
	}
}
