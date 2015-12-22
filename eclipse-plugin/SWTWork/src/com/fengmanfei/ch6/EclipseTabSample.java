package com.fengmanfei.ch6;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class EclipseTabSample {

	public static void main(String[] args) {
		Display display = new Display();
		// ����ͼƬ���󣬸�ͼƬ��������ѡ��ϵ�ͼ��
		Image image = new Image(
				display,
				"F:\\javaDev\\eclipse\\plugins\\org.eclipse.platform_3.1.2\\intro\\css\\graphics\\icons\\etool\\samples.gif");
		final Shell shell = new Shell(display);
		shell.setText("��Eclipse�༭����ѡ�");
		shell.setLayout(new GridLayout());
		// �����Զ���ѡ�����
		final CTabFolder folder = new CTabFolder(shell, SWT.BORDER);
		// ����ѡ��Ĳ��֣�ͨ�����ֵ����ó��ֳ���󻯺���С�������
		folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		// ���ø��ӵ�ѡ���Ҳ���Ǵ���Բ�ǵ�ѡ���ǩ
		folder.setSimple(false);
		// ����δѡ�б�ǩ��ͼ��͹رհ�ť��״̬
		folder.setUnselectedImageVisible(true);
		folder.setUnselectedCloseVisible(true);
		// ����ǰ��ɫ�ͱ���ɫ
		folder.setSelectionForeground(display.getSystemColor(SWT.COLOR_WHITE));
		folder.setSelectionBackground(display.getSystemColor(SWT.COLOR_BLUE));
		// ��ʾ��󻯺���С����ť
		folder.setMinimizeVisible(true);
		folder.setMaximizeVisible(true);
		// ����ѡ���ǩ����
		for (int i = 1; i < 5; i++) {
			CTabItem item = new CTabItem(folder, SWT.CLOSE);
			item.setText("ѡ� " + i);
			item.setImage(image);
			// ÿ��ѡ��з���һ��Text�ı���
			Text text = new Text(folder, SWT.MULTI | SWT.V_SCROLL
					| SWT.H_SCROLL);
			// �ı����е����ִ���\n��ʾ����ʾʱ������һ��
			text.setText("���ǵ�" + i + "ҳ:\n��ѡ�����Eclipse���\n��󻯺���С����ť������ʹ��");
			item.setControl(text);
		}
		// ע��ѡ��¼�
		folder.addCTabFolder2Listener(new CTabFolder2Adapter() {
			// ��������С����ťʱ�������¼�
			public void minimize(CTabFolderEvent event) {
				// ����ѡ���״̬Ϊ��С����ѡ���״̬������ʾ�����ϽǵĴ��ڰ�ť
				folder.setMinimized(true);
				// �ı�ѡ��Ĳ��֣�������С��״̬
				folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
						false));
				// ˢ�²��֣������������õĲ��ֽ���������
				shell.layout(true);
			}

			// ��������󻯰�ťʱ�������¼�
			public void maximize(CTabFolderEvent event) {
				folder.setMaximized(true);
				folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
						true));
				shell.layout(true);
			}

			// ��������ԭ��ťʱ�������¼�
			public void restore(CTabFolderEvent event) {
				folder.setMinimized(false);
				folder.setMaximized(false);
				folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
						false));
				shell.layout(true);
			}
		});
		shell.setSize(300, 200);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		// �ͷ�ͼƬ��Դ
		image.dispose();
		display.dispose();
	}

}
