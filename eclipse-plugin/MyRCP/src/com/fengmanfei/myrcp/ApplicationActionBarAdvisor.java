package com.fengmanfei.myrcp;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;


public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private NewAction newAction;//�Զ����action
	private IWorkbenchAction exitAction;//�˳�
	private IWorkbenchAction aboutAction;//����
	private IWorkbenchAction refAction;
	private IWorkbenchAction helpAction;
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
		newAction = new NewAction();//����action����
		register(newAction);//���෽����ע��ò���
		exitAction = ActionFactory.QUIT.create(window);//Eclipse���õ��˳�����
		register(exitAction);
		aboutAction = ActionFactory.ABOUT.create(window);//���õĹ��ڲ���
		register(aboutAction);
		refAction = ActionFactory.PREFERENCES.create(window);
		register(refAction);
		helpAction = ActionFactory.HELP_CONTENTS.create(window);
		register(helpAction);
	}
	//���Ǹ����еķ����������˵���
	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager codeMenu = new MenuManager("CodeMenu(&C)","fileMenu");
		codeMenu.add(newAction);
		codeMenu.add(aboutAction);
		codeMenu.add(refAction);
		codeMenu.add(exitAction);
		codeMenu.add(helpAction);
		menuBar.add(codeMenu);
	}
	//���Ǹ����еķ���������������
	protected void fillCoolBar(ICoolBarManager coolBar) {
		  IToolBarManager toolbar = new ToolBarManager(coolBar.getStyle());
		  toolbar.add(helpAction);
		  coolBar.add(toolbar);
	}
	//�̳���Action
	class NewAction extends Action {
		NewAction() {
			super("new");
			this.setId("NewAction");
		}

		public void run() {
		}
	}
}
