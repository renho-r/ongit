package com.renho.e78.section;

import java.util.HashMap;
import java.util.Map;

public class Client {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		final Runtime rt = Runtime.getRuntime();
		// JVM��ֹǰ��¼�ڴ���Ϣ
		rt.addShutdownHook(new Thread() {
			@Override
			public void run() {
				StringBuffer sb = new StringBuffer();
				long heapMaxSize = rt.maxMemory() >> 20;
				sb.append("�������ڴ棺" + heapMaxSize + "M\n");
				long total = rt.totalMemory() >> 20;
				sb.append("���ڴ��С��" + total + "M\n");
				long free = rt.freeMemory() >> 20;
				sb.append("�����ڴ棺" + free + "M");
				System.out.println(sb);
			}
		});
		// ����40���ֵ��
		for (int i = 0; i < 400 * 10000; i++) {
			map.put("key" + i, "vlaue" + i);
		}
	}
}
