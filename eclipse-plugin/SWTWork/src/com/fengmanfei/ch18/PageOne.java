package com.fengmanfei.ch18;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class PageOne extends PreferencePage {
	protected Control createContents(Composite parent) {
		return parent;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#contributeButtons(org.eclipse.swt.widgets.Composite)
	 */
	protected void contributeButtons(Composite parent) {
		// super.contributeButtons(parent);
		Button bt1 = new Button(parent, SWT.NONE);
		bt1.setText("��ťһ");
		((GridLayout) parent.getLayout()).numColumns++;
		Button bt2 = new Button(parent, SWT.NONE);
		bt2.setText("��ť��");
		((GridLayout) parent.getLayout()).numColumns++;

	}

}
