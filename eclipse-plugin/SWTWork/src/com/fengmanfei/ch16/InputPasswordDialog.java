package com.fengmanfei.ch16;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import com.fengmanfei.util.ImageFactory;

public class InputPasswordDialog extends TitleAreaDialog{

	private Text userName;
	private Text password;
	private Text confirmPassword;
	public final String DEFAULT_INFO="������Ҫע����û����ĺ�����";
	public InputPasswordDialog(Shell parentShell) {
		super(parentShell);
	}
	/* ���� Javadoc��
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createContents(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createContents(Composite parent) {
		super.createContents(parent);
		this.getShell().setText("�û�ע��Ի���");//���öԻ��������
		this.setTitle("�û�ע��");//���ñ�����Ϣ
		this.setMessage("������Ҫע����û���������",IMessageProvider.INFORMATION);//���ó�ʼ���Ի������ʾ��Ϣ
		//�����Ҳ��ͼƬ��һ��Ϊ48*48��С
		this.setTitleImage( ImageFactory.loadImage( Display.getCurrent(), ImageFactory.SAMPLE_ICON));
		return parent;
	}

	/* ���� Javadoc��
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 * ���Ǹ÷��������Դ����Ի�����ʾ����������
	 */
	protected Control createDialogArea(Composite parent) {
		super.createDialogArea(parent);
		Composite composite = new Composite(parent , SWT.NONE);
		composite.setLayout( new GridLayout(2,true));
		new Label( composite , SWT.NONE).setText("�û�����");
		userName = new Text(composite ,SWT.BORDER);
		userName.addFocusListener( new FocusAdapter(){
			//���û����ı���ʧȥ����ʱ���ж��Ƿ���Ч
			public void focusLost(FocusEvent e) {
				checkValid();				
			}	
		});
		new Label( composite , SWT.NONE).setText("���룺");
		password = new Text(composite ,SWT.BORDER);
		password.setEchoChar('*');
		new Label( composite , SWT.NONE).setText("ȷ�����룺");
		confirmPassword = new Text(composite ,SWT.BORDER);
		confirmPassword.setEchoChar('*');
		confirmPassword.addFocusListener( new FocusAdapter(){
			//��ȷ�������ı���ʧȥ����ʱ���ж��Ƿ���Ч
			public void focusLost(FocusEvent e) {
				checkValid();				
			}	
		});
		return parent;
	}
	//�ж����Ƿ�������Ч������ʾ�û�
	protected void checkValid() {
		if (!password.getText().equals(confirmPassword.getText()))
			setMessage("ȷ�����벻һ�£�����������!",IMessageProvider.WARNING);
		else if ( userName.getText().equals(""))
			setMessage("�û�������Ϊ��!",IMessageProvider.ERROR);
		else
			setMessage(DEFAULT_INFO);
	}
}
