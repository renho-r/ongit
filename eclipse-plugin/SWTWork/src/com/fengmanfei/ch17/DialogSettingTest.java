package com.fengmanfei.ch17;

import java.io.IOException;
import org.eclipse.jface.dialogs.DialogSettings;

public class DialogSettingTest {

	public static void main(String[] args) {
		// �����Ի������ö���
		DialogSettings settings = new DialogSettings("survey");
		// ����key��value
		settings.put("Q1", 0);
		settings.put("Q2", 1);
		settings.put("Q3", 2);
		// ���浽�ļ���
		try {
			settings.save("f:\\dialog.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}

		settings = new DialogSettings(null);
		try {
			settings.load("f:\\dialog.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Q1=" + settings.get("Q1"));
		System.out.println("Q2=" + settings.get("Q2"));
		System.out.println("Q3=" + settings.get("Q3"));
	}
}
