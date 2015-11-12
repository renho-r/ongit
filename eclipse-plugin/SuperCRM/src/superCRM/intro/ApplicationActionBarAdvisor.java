package superCRM.intro;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import superCRM.action.ActionManager;
import superCRM.views.ContactSummaryView;
import superCRM.views.CustomerSummaryView;
import superCRM.views.NavView;
import superCRM.views.QuickNewContactView;
import superCRM.views.QuickNewCustomerView;
import superCRM.views.SearchView;

/** ���ڵĲ˵����� */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	/** �½��˵��Ĳ˵��� */
	private IWorkbenchAction newCustomerAction;

	private IWorkbenchAction newContactAction;

	private IWorkbenchAction exitAction;

	/** �鿴�˵��Ĳ˵��� */
	private IWorkbenchAction viewNavAction;

	private IWorkbenchAction viewSearchAction;

	private IWorkbenchAction viewFastNewCustomerAction;

	private IWorkbenchAction viewFastNewCintactAction;

	private IWorkbenchAction viewCustomerAction;

	private IWorkbenchAction viewContactAction;

	/** �����˵��Ĳ˵��� */
	private IWorkbenchAction introAction;

	private IWorkbenchAction helpAction;

	private IWorkbenchAction aboutAction;

	private IWorkbenchAction preferenceAction;

	/** ���췽�� */
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
		/** �½��ͻ����� */
		newCustomerAction = ActionManager.createNewCustomerAction(window);
		register(newCustomerAction);
		
		/** �½���ϵ�˲��� */
		newContactAction = ActionManager.createNewContactAction(window);
		register(newContactAction);
		
		/**�˳�����*/
		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);

		/**�鿴������ͼ����*/
		viewNavAction = ActionManager.createShowViewAction(window, NavView.ID);
		register(viewNavAction);
		
		/**�鿴������ͼ����*/
		viewSearchAction = ActionManager.createShowViewAction(window, SearchView.ID);
		register(viewSearchAction);
		
		/**�鿴�����½��ͻ���ͼ����*/
		viewFastNewCustomerAction = ActionManager.createShowViewAction(window, QuickNewCustomerView.ID);
		register(viewFastNewCustomerAction);
		
		/**�鿴�����½���ϵ����ͼ����*/
		viewFastNewCintactAction = ActionManager.createShowViewAction(window, QuickNewContactView.ID);
		register(viewFastNewCintactAction);
		
		/**�鿴�ͻ��б���ͼ����*/
		viewCustomerAction = ActionManager.createShowViewAction(window, CustomerSummaryView.ID);
		register(viewCustomerAction);
		
		/**�鿴��ϵ���б���ͼ����*/
		viewContactAction = ActionManager.createShowViewAction(window, ContactSummaryView.ID);
		register(viewContactAction);

		/**�򿪻�ӭ��ͼ����*/
		introAction = ActionFactory.INTRO.create(window);
		register(introAction);
		
		/**�򿪰������ڲ���*/
		helpAction = ActionFactory.HELP_CONTENTS.create(window);
		register(helpAction);
		
		/**�򿪹��ڴ��ڲ���*/
		aboutAction = ActionFactory.ABOUT.create(window);
		register(aboutAction);

		/**����ѡ�����*/
		preferenceAction = ActionFactory.PREFERENCES.create(window);
		register(preferenceAction);
	}
	
	/**
	 * �����˵���,����Ӳ˵���
	 */
	protected void fillMenuBar(IMenuManager menuBar) {

		MenuManager systemMenu = new MenuManager("�½�(&N)");
		systemMenu.add(newCustomerAction);
		systemMenu.add(newContactAction);
		systemMenu.add(new Separator());
		systemMenu.add(exitAction);
		menuBar.add(systemMenu);

		MenuManager viewMenu = new MenuManager("�鿴(&V)");
		viewMenu.add(viewNavAction);
		viewMenu.add(viewSearchAction);
		viewMenu.add(new Separator());
		viewMenu.add(viewFastNewCustomerAction);
		viewMenu.add(viewFastNewCintactAction);
		viewMenu.add(new Separator());
		viewMenu.add(viewCustomerAction);
		viewMenu.add(viewContactAction);
		menuBar.add(viewMenu);

		MenuManager helpMenu = new MenuManager("����(&H)", IWorkbenchActionConstants.M_HELP);
		helpMenu.add(introAction);
		helpMenu.add(helpAction);
		helpMenu.add(aboutAction);
		helpMenu.add(preferenceAction);
		menuBar.add(helpMenu);
	}
	/**
	 * ����������,����ӹ��߰�ť
	 */
	protected void fillCoolBar(ICoolBarManager coolBar) {
		IToolBarManager barManager = new ToolBarManager(coolBar.getStyle());
		barManager.add(newCustomerAction);
		barManager.add(newContactAction);
		barManager.add(new Separator());
		barManager.add(viewNavAction);
		barManager.add(viewSearchAction);
		
		barManager.add(viewFastNewCustomerAction);
		barManager.add(viewFastNewCintactAction);
		
		barManager.add(viewCustomerAction);
		barManager.add(viewContactAction);
		coolBar.add(barManager);
	}
	/**
	 * ���ϵͳ������ʹ�õĲ�����
	 * 
	 * @param trayMenu
	 */
	public void fillTrayItem(MenuManager trayMenu) {
		trayMenu.add(aboutAction);
		trayMenu.add(introAction);
		trayMenu.add(new Separator());
		trayMenu.add(exitAction);

	}
}
