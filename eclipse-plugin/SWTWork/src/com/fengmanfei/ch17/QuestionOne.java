package com.fengmanfei.ch17;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.jface.dialogs.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
public class QuestionOne extends WizardPage{

	public QuestionOne() {
		super(BookSurveyWizard.Q1,"����1:",ImageDescriptor.createFromFile(QuestionOne.class,"q.gif"));
		//���ñ�����Ϣ
		this.setMessage("����Ϊ������Ѷ��ǣ�");
	}

	//�÷���Ϊ����ʵ�ֵķ������ڸ÷����д�����ҳ��Ŀؼ�
	public void createControl(Composite parent) {
	    Composite composite = new Composite(parent, SWT.NONE);
	    composite.setLayout(new GridLayout(2,false));
	    new Label(composite, SWT.LEFT).setText("A.");
	    Button b1 = new Button( composite, SWT.RADIO);
	    b1.setText("̫��");
	    b1.setSelection(true);
	    new Label(composite, SWT.LEFT).setText("B.");
	    Button b2 = new Button( composite, SWT.RADIO);
	    b2.setText("������");
	    new Label(composite, SWT.LEFT).setText("C.");
	    Button b3 = new Button( composite, SWT.RADIO);
	    b3.setText("̫��");
	    //�÷����ǳ���Ҫ����������ʾ���õĿؼ�
	    setControl(composite);
	}
	/* ���� Javadoc��
	 * @see org.eclipse.jface.dialogs.DialogPage#performHelp()
	 */
	public void performHelp() {
		MessageDialog.openInformation(Display.getCurrent().getActiveShell(),"����","����ϵABC@yahoo.com.cn!");
	}

}
