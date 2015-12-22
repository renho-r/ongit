package com.fengmanfei.ch16;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;


public class MessageDialogTest extends ApplicationWindow { 

	public MessageDialogTest() {
		super(null);
	}
	
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setSize(550,300);
		shell.setText("��Ϣ�Ի���ʾ��");
	}

	protected Control createContents(Composite parent) {
		//�����е�������һ���ı�����Ϊ��Ϣ���̨�ͼ�����ť�ֱ�򿪲�ͬ�ĶԻ���
		Composite composite = new Composite( parent ,SWT.NONE);
		GridLayout gridLayout = new GridLayout (6,false);
		composite.setLayout( gridLayout );
		final Text console = new Text ( composite ,SWT.NONE|SWT.READ_ONLY|SWT.V_SCROLL);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan=6;
		console.setLayoutData( data);
		Button openError = new Button( composite ,SWT.NONE);
		openError.setText("������Ϣ�Ի���");
		openError.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openError(Display.getCurrent().getActiveShell(),"������Ϣ�Ի���","��ȡ�ļ���������");
				console.append("\n openError�Ի��򣬷���void");
			}	
		});
		Button openConfirm = new Button( composite ,SWT.NONE);
		openConfirm.setText("ȷ����Ϣ�Ի���");
		openConfirm.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				boolean b = MessageDialog.openConfirm(Display.getCurrent().getActiveShell(),
						"ȷ����Ϣ�Ի���",
						"ȷʵҪ�����ļ���");
				console.append("\n openConfirm�Ի��򣬷���"+b);
			}
		});
		Button openInformation = new Button( composite ,SWT.NONE);
		openInformation.setText("��Ϣ�Ի���");
		openInformation.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(),"��Ϣ�Ի���","ȷʵҪ�����ļ���");
				console.append("\n openInformation�Ի��򣬷���void");
			}
		});
		Button openQuestion = new Button( composite ,SWT.NONE);
		openQuestion.setText("ѯ�ʶԻ���");
		openQuestion.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				boolean b = MessageDialog.openQuestion(Display.getCurrent().getActiveShell(),"ѯ�ʶԻ���","ȷʵҪ�����ļ���");
				console.append("\n openQuestion�Ի��򣬷���"+b);
			}
		});
		Button openWarning = new Button( composite ,SWT.NONE);
		openWarning.setText("����Ի���");
		openWarning.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openWarning(Display.getCurrent().getActiveShell(),"����Ի���","ȷʵҪ�����ļ���");
				console.append("\n openWarning�Ի��򣬷���void");
			}
		});
		Button customMessageDig = new Button( composite ,SWT.NONE);
		customMessageDig.setText("�Զ���Ի���");
		customMessageDig.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				MessageDialog dialog = new MessageDialog(Display.getCurrent().getActiveShell(),//shell����
						"���ǶԻ���ı���",//����
						null,//�Ի����ͼ�꣬Ϊnull����ʾͼ��
						"����һ���Զ���ĶԻ��򣬿��Ըı䰴ť������",//�Ի����е���ʾ��Ϣ
						MessageDialog.INFORMATION,//��ʾ��Ϣ��ͼ��
						new String[]{"�鿴","����","ȷ��"},//��ʾ������ť
						1);//Ĭ��ѡ��İ�ť������ֵ������Ϊ1����ʾĬ��ѡ�еڶ�����ť��Ҳ���Ǳ��水ť
				int i = dialog.open();//����ֵΪ��ť
				console.append("\n �Զ���Ի��򣬷��ذ�ť������ֵ"+i);
			}
		});
		return parent;
	}
	public static void main(String[] args) {
		MessageDialogTest test = new MessageDialogTest();
		test.setBlockOnOpen( true );
		test.open();
		Display.getCurrent().dispose();
	}

}