package com.fengmanfei.ch17;

import org.eclipse.jface.wizard.Wizard;

public class BookSurveyWizard extends Wizard {

	public static final String Q1 = "QUESTION_1";
	public static final String Q2 = "QUESTION_2";
	public static final String ASK_FOR_CONTACT = "ASK_FOR_CONTACT";
	public static final String EMAIL = "EMAIL";
	public static final String THANKS = "THANKS";
	//�����򵼵�����ҳ��
	private QuestionOne one;
	private QuestionTwo two;
	private Thanks thanks;
	public BookSurveyWizard(){
		//����������ҳ�����
		one = new QuestionOne();
		two = new QuestionTwo();
		thanks = new Thanks();
		//�ֱ����������ҳ��
		this.addPage( one );
		this.addPage( two );
		this.addPage( new AskForContact());
		this.addPage( new Email());
		this.addPage( thanks );
		this.setWindowTitle("���ߵ�����");//�򵼱���
		this.setHelpAvailable( true );
	}
	/* ���� Javadoc��
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 * ȷ������ɡ���ť�Ƿ����,trueΪ���ã�falseΪ������
	 */
	public boolean canFinish() {
		//������ǰҳ��Ϊ��лҳ��ʱ�Ž�����ɡ���ť��Ϊ����״̬
		if (this.getContainer().getCurrentPage() == thanks )
			return true;
		else
			return false;
	}
	//����ʵ�ָ÷�������������ɰ�ť����ô˷���
	public boolean performFinish() {
		return true;
	}
}
