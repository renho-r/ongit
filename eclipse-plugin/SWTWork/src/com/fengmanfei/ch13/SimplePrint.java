package com.fengmanfei.ch13;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;

public class SimplePrint {
	public static void main(String[] args) {
		PrinterData data = Printer.getDefaultPrinterData();
		if (data == null) {
			return;
		}
		Printer printer = new Printer(data);
		//��ʼ��ӡ����
		if (printer.startJob("Simple Print")) {
			Color black = printer.getSystemColor(SWT.COLOR_BLACK);
			Color gray = printer.getSystemColor(SWT.COLOR_GRAY);
			Color red = printer.getSystemColor(SWT.COLOR_RED);
			//������߾���ϱ߾��λ��
			Rectangle trim = printer.computeTrim(0, 0, 0, 0);
			Point dpi = printer.getDPI();
			int leftMargin = dpi.x + trim.x;
			int topMargin = dpi.y / 2 + trim.y;
			//����ͼ�������Ķ���
			GC gc = new GC(printer);
			Font font = gc.getFont();
			//��ӡ��һҳ
			if (printer.startPage()) {
				gc.setBackground(gray);
				gc.setForeground(black);
				String testString = "Hello World!";
				//ʹ��gc�����ַ����ķ�����ʾ�ַ�
				gc.drawString(testString, leftMargin, topMargin + font.getFontData()[0].getHeight());
				printer.endPage();
			}
			//��ӡ�ڶ�ҳ
			if (printer.startPage()) {
				gc.setBackground(gray);
				gc.setForeground(black);
				String testString = "Hello World!";
				Point extent = gc.stringExtent(testString);
				gc.drawString(testString, leftMargin, topMargin + font.getFontData()[0].getHeight());
				gc.setForeground(red);
				gc.drawRectangle(leftMargin, topMargin, extent.x, extent.y);
				printer.endPage();
			}
			//�ͷ�gc����
			gc.dispose();
			//������ӡ����
			printer.endJob();
		}
		printer.dispose();
	}
}
