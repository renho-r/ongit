package com.fengmanfei.ch17;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class AskForContact extends WizardPage {

	private Button no;
	private Button yes;
	protected AskForContact() {
		super(BookSurveyWizard.ASK_FOR_CONTACT, "�������ṩ��ϵ��ʽ��", ImageDescriptor.createFromFile(QuestionOne.class, "q.gif"));
		this.setMessage("�����������ϵ��ʽ�����л���μӳ齱���");
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		new Label(composite, SWT.LEFT).setText("A.");
		no = new Button(composite, SWT.RADIO);
		no.setText("�����Ҳ�������ϵ��ʽ");
		no.setSelection(true);
		new Label(composite, SWT.LEFT).setText("B.");
		yes = new Button(composite, SWT.RADIO);
		yes.setText("������Ը��������ϵ��ʽ");
		setControl(composite);
	}
	//�ж��Ƿ���Ҫ������ϵ��ʽ
	public boolean canContact() {
		if (yes.getSelection() == true)
			return true;
		return false;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 * ���Ǹ����еĸ÷�������������һҳ����ʾ��ҳ��
	 */
	public IWizardPage getNextPage() {
		//���������ϵ��ʽ���򷵻���һҳ
		if (canContact())
			return super.getNextPage();
		//���򷵻ظ�лҳ��
		return getWizard().getPage(BookSurveyWizard.THANKS);
	}
}
