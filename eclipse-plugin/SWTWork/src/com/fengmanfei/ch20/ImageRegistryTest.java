package com.fengmanfei.ch20;

import org.eclipse.jface.resource.*;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

public class ImageRegistryTest extends ApplicationWindow {

	private static final String ONE = "one";
	private static final String TWO = "two";
	private static final String THREE = "three";
	public ImageRegistryTest() {
		super(null);
	}

	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());

		//�������ļ����뵽ImageRegistry��
		ImageRegistry ir = new ImageRegistry();
		ir.put(ONE, ImageDescriptor.createFromFile(ImageRegistryTest.class,"one.gif"));
		ir.put(TWO, ImageDescriptor.createFromFile(ImageRegistryTest.class,"two.gif"));
		ir.put(THREE, ImageDescriptor.createFromFile(ImageRegistryTest.class,"three.gif"));

		//ȡ��ͼƬ
		Label label = new Label(composite, SWT.NONE);
		label.setImage(ir.get(ONE));
		label = new Label(composite, SWT.NONE);
		label.setImage(ir.get(TWO));
		label = new Label(composite, SWT.NONE);
		label.setImage(ir.get(THREE));

		getShell().pack();
		return composite;
	}

	public static void main(String[] args) {
		ImageRegistryTest test = new ImageRegistryTest();
		test.setBlockOnOpen(true);
		test.open();
		Display.getCurrent().dispose();

	}
}
