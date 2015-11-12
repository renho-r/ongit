package com.fengmanfei.ch9;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class DialogSample {

	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout( new GridLayout());
		shell.setText("Dialog Sample");
		
		Button b1 = new Button ( shell,SWT.NONE);
		b1.setText("��Ϣ��ʾ��");
		b1.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				//������Ϣ�����ʹ�þ���ͼ�겢��ʾ�Ǻͷ�ť
				MessageBox box = new MessageBox( shell ,SWT.ICON_ERROR|SWT.YES|SWT.NO);
				//���öԻ���ı���
				box.setText("������Ϣ�Ի���");
				//���öԻ�����ʾ����Ϣ
				box.setMessage("��ȡ�ļ���������!");
				//�򿪶Ի��򣬽�����ֵ����choice
				int choice = box.open();
				//��ӡ����ѡ���ֵ
				if (choice==SWT.YES)
					System.out.print("Yes");
				else if ( choice==SWT.NO)
					System.out.print("No");
			}
			
		});
		
		Button b2 = new Button ( shell,SWT.NONE);
		b2.setText("Ŀ¼ѡȡ�Ի���");
		b2.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dialog = new DirectoryDialog(shell);
				//������ʾ�ڴ����Ϸ�����ʾ��Ϣ
				dialog.setMessage("��ѡ����Ҫ������ļ���");
				//���öԻ���ı���
				dialog.setText("ѡ���ļ�Ŀ¼");
				//���ô�ʱĬ�ϵ��ļ�Ŀ¼
				dialog.setFilterPath("C:\\");
				//�򿪴��ڣ������û���ѡ���ļ�Ŀ¼
				String saveFile = dialog.open();
				if ( saveFile != null )
				{
					//����һ��File����
					File directory = new File(saveFile);
					System.out.print(directory.getPath());
				}
			}
		});
		
		Button b3 = new Button ( shell,SWT.NONE);
		b3.setText("�ļ��Ի���");
		b3.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				//����һ���򿪶Ի�����ʽ����ΪSWT.OPEN
				FileDialog dialog = new FileDialog(shell,SWT.OPEN);
				//���ô�Ĭ�ϵ�·��
				dialog.setFilterPath(System.getProperty("java.home"));
				//���������ļ�����չ��
				dialog.setFilterExtensions(new String[] {"*.txt", "*.*"});
				//������ʾ���������е���չ��������
				dialog.setFilterNames( new String[]{"Text Files (*.txt)", "All Files (*.*)"});
				//�򿪴��ڣ������û���ѡ���ļ�Ŀ¼
				String file = dialog.open();
				if ( file != null )
				{
					System.out.print(file);
				}
			}
		});
		
		Button b4 = new Button ( shell,SWT.NONE);
		b4.setText("��ɫ�Ի���");
		b4.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				//����һ����ɫ�Ի���
				ColorDialog dialog = new ColorDialog(shell);
				//����Ĭ��ѡ�е���ɫ
				dialog.setRGB( new RGB( 255 ,255 ,128));
				//�򿪶Ի��򣬽�ѡ�е���ɫ���ظ�rgb����
				RGB rgb = dialog.open();
				if ( rgb != null )
				{
					System.out.print(rgb);
					//������ɫ����
					Color  color = new Color( display , rgb );
					//��ʹ������ɫ������ͷ���Դ
					color.dispose();
					
				}
			}
		});
		
		Button b5 = new Button ( shell,SWT.NONE);
		b5.setText("����Ի���");
		b5.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				//����һ������Ի���
				FontDialog  dialog = new FontDialog (shell);
				//����Ĭ��ѡ�е���ɫ
				dialog.setRGB( new RGB( 255 ,255 ,128));
				//�򿪶Ի��򣬽�ѡ�е����巵�ظ�fontData����
				FontData fontData = dialog.open();
				if ( fontData != null )
				{
					System.out.print(fontData);
					//������ɫ����
					Font  font = new Font( display , fontData );
					//��ʹ�������������ͷ���Դ
					font.dispose();
				}
			}
		});
		
		Button b6 = new Button ( shell,SWT.NONE);
		b6.setText("����Ի���");
		b6.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				//����һ����ӡ�Ի���
				PrintDialog  dialog = new PrintDialog (shell);
				//�򿪶Ի��򣬽�ѡ�е����巵�ظ�fontData����
				PrinterData printData = dialog.open();
				if ( printData != null )
				{
					//������ӡ����
					Printer  printer = new Printer( printData );
					//��ʹ�ô�ӡ������ͷ���Դ
					printer.dispose();
				}
			}
		});
		
		//shell.setSize(200, 150);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}
	
}
