package com.fengmanfei.ch15;

import org.eclipse.jface.action.*;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

import com.fengmanfei.ch15.actions.*;

public class MainWindow extends ApplicationWindow {

	private NewAction newAction;// �½��˵���

	private OpenAction openAction;// �򿪲˵���

	private SaveAction saveAction;// ����˵���

	private SaveAsAction saveAsAction;// ���Ϊ�˵���

	private ExitAction exitAction;// �˳��˵���

	private CopyAction copyAction;// ���Ʋ˵���

	private CutAction cutAction;// ���в˵���

	private PasteAction pasteAction;// ճ���˵���

	private HelpAction helpAction;// �����˵���

	private FileManager manager;// �ļ�������

	private Text content;// �ı���

	private static MainWindow app;// �����򴰿�

	private MainWindow() {
		super(null);
		app = this;
		manager = new FileManager();
		// ��ʼ����ť����
		newAction = new NewAction();
		openAction = new OpenAction();
		saveAction = new SaveAction();
		saveAsAction = new SaveAsAction();
		exitAction = new ExitAction();
		copyAction = new CopyAction();
		cutAction = new CutAction();
		pasteAction = new PasteAction();
		helpAction = new HelpAction();

		this.addMenuBar();// ��Ӳ˵���
		this.addToolBar(SWT.FLAT);
		this.addStatusLine();
	}

	/**
	 * @return ���� app��
	 */
	public static MainWindow getApp() {
		return app;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.window.ApplicationWindow#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setMaximized(true);//�������
		shell.setText("��д�ְ�");
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.window.Window#createContents(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createContents(Composite parent) {
		content = new Text(parent, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		content.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				manager.setDirty(true);
			}
		});
		return parent;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.window.ApplicationWindow#createMenuManager()
	 */
	protected MenuManager createMenuManager() {
		MenuManager menuBar = new MenuManager();// �����ò˵�������

		MenuManager fileMenu = new MenuManager("�ļ�(&F)"); // �ļ��˵���
		MenuManager editMenu = new MenuManager("�༭(&E)"); // �༭�˵���
		MenuManager formatMenu = new MenuManager("��ʽ(&M)"); // ��ʽ�˵���
		MenuManager helpMenu = new MenuManager("����(&H)"); // �����˵���

		// ���˵�����ӵ����˵���
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(formatMenu);
		menuBar.add(helpMenu);

		// �ļ��˵���
		fileMenu.add(newAction);
		fileMenu.add(openAction);
		fileMenu.add(new Separator());
		fileMenu.add(saveAction);
		fileMenu.add(saveAsAction);
		fileMenu.add(new Separator());
		fileMenu.add(exitAction);

		editMenu.add(copyAction);
		editMenu.add(cutAction);
		editMenu.add(pasteAction);

		formatMenu.add(new FormatAction(FormatAction.TYPE_FONT));
		formatMenu.add(new FormatAction(FormatAction.TYPE_BGCOLOR));
		formatMenu.add(new FormatAction(FormatAction.TYPE_FORECOLOR));

		helpMenu.add(helpAction);

		return menuBar;

	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.window.ApplicationWindow#createToolBarManager(int)
	 */
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBar = new ToolBarManager(style);
		toolBar.add(newAction);
		toolBar.add(openAction);
		toolBar.add(saveAction);
		toolBar.add(saveAsAction);
		toolBar.add(new Separator());
		toolBar.add(copyAction);
		toolBar.add(cutAction);
		toolBar.add(pasteAction);
		toolBar.add(new Separator());
		toolBar.add(new FormatAction(FormatAction.TYPE_FONT));
		toolBar.add(new FormatAction(FormatAction.TYPE_BGCOLOR));
		toolBar.add(new FormatAction(FormatAction.TYPE_FORECOLOR));
		return toolBar;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.window.ApplicationWindow#getStatusLineManager()
	 */
	public StatusLineManager getStatusLineManager() {
		return super.getStatusLineManager();
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.window.ApplicationWindow#createStatusLineManager()
	 */
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	public static void main(String[] args) {
		MainWindow main = new MainWindow();
		main.setBlockOnOpen(true);
		main.open();
		Display.getCurrent().dispose();
	}

	/**
	 * @return ���� content��
	 */
	public Text getContent() {
		return content;
	}

	/**
	 * @return ���� manager��
	 */
	public FileManager getManager() {
		return manager;
	}

	/**
	 * @param manager
	 *            Ҫ���õ� manager��
	 */
	public void setManager(FileManager manager) {
		this.manager = manager;
	}
}
