package com.fengmanfei.ch13;

import java.io.File;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.ole.win32.OLE;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.widgets.*;

public class OleSample {
	private Shell sShell;
	private MenuItem[] fileItem;//OLE�Ĳ˵���
	private OleClientSite clientSite;//OLE�ؼ�����
	private OleFrame frame;//OLE�����Ķ���
	private File openFile;//�򿪵��ļ�
	public static void main(String[] args) {
		Display display = Display.getDefault();
		OleSample thisClass = new OleSample();
		thisClass.createSShell();
		thisClass.sShell.open();
		while (!thisClass.sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		thisClass.clientSite.dispose();
		display.dispose();
	}

	private void createSShell() {
		sShell = new Shell();
		sShell.setText("OLE Sample");
		sShell.setLayout(new FillLayout());
		createMenu();
		sShell.setSize(new Point(300, 200));
	}
	//����OLE�ؼ�����
	private void createOle() {
		frame = new OleFrame(sShell, SWT.NONE);
		frame.setFileMenus(fileItem);
		if (openFile != null)
			clientSite = new OleClientSite(frame, SWT.NONE, openFile);
		clientSite.doVerb(OLE.OLEIVERB_PRIMARY);
	}

	private void createMenu() {
		Menu main = new Menu(sShell, SWT.BAR);

		MenuItem file = new MenuItem(main, SWT.CASCADE);
		file.setText("�ļ�(&F)");

		Menu fileMenu = new Menu(file);
		fileItem = new MenuItem[2];
		fileItem[0] = new MenuItem(fileMenu, SWT.PUSH);
		fileItem[0].setText("��");
		fileItem[1] = new MenuItem(fileMenu, SWT.PUSH);
		fileItem[1].setText("����");
		file.setMenu(fileMenu);

		sShell.setMenuBar(main);

		fileItem[0].addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(sShell, SWT.OPEN);
				dialog.setFilterExtensions(new String[] { "*.doc", "*.*" });
				String file = dialog.open();
				if (file != null) {
					openFile = new File(file);
					//��OLE�ؼ�
					createOle();
				}
			}

		});
		fileItem[1].addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				//������ļ����޸Ĺ�
				if (clientSite.isDirty()) {
					//����һ����ʱ�ļ�
					File tempFile = new File(openFile.getAbsolutePath() + ".tmp");
					openFile.renameTo(tempFile);
					//�������ɹ�����ɾ����ʱ�ļ�������ָ�����ʱ�ļ������״̬
					if (clientSite.save(openFile, true))
						tempFile.delete();
					else
						tempFile.renameTo(openFile);
				}
			}
		});
	}

}
