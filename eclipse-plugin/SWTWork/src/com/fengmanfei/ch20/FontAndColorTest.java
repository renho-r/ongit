package com.fengmanfei.ch20;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class FontAndColorTest extends ApplicationWindow {

	//ʹ�õ�key����
	private static final String FONT_ONE = "font_one";
	private static final String FONT_TWO = "font_two";
	private static final String COLOR_BLUE = "blue";
	private static final String COLOR_GREEN = "green";
	//FontRegistry����
	private static FontRegistry  fontRegistry;
	//ColorRegistry����
	private static ColorRegistry  colorRegistry;
	public FontAndColorTest() {
		super(null);
	}
	
	private void loadFontAndColor() {
		//��ʼ���������ɫע��������
		fontRegistry = new FontRegistry();
		colorRegistry = new ColorRegistry();
		//�������
		FontData fontData = new FontData("����",24, SWT.BOLD);
		fontRegistry.put(FONT_ONE,new FontData[]{ fontData });
		fontData = new FontData("����",30, SWT.NORMAL);
		fontRegistry.put(FONT_TWO,new FontData[]{ fontData });
		//�����ɫ
		colorRegistry.put(COLOR_BLUE, new RGB(0,128,255));
		colorRegistry.put(COLOR_GREEN, new RGB(128,255,128));
		
	}

	protected Control createContents(Composite parent) {
		//��ʼ���������ɫ
		loadFontAndColor();
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());
		//���������������ɫ��ͬ�ı�ǩ
		Label label = new Label( composite , SWT.NONE);
		label.setText("��ʽһ");
		label.setFont( fontRegistry.getItalic(FONT_ONE));
		label.setBackground( colorRegistry.get(COLOR_BLUE ));
		
		label = new Label( composite , SWT.NONE);
		label.setText("��ʽ��");
		label.setFont( fontRegistry.getBold(FONT_TWO));
		label.setBackground( colorRegistry.get(COLOR_GREEN ));
		
		return parent;
	}

	public static void main(String[] args) {
		FontAndColorTest test = new FontAndColorTest();
		test.setBlockOnOpen(true);
		test.open();
		Display.getCurrent().dispose();
	}
}
