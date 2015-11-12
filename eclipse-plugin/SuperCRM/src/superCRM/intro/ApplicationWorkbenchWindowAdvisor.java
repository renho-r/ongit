package superCRM.intro;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import superCRM.SuperCRMPlugin;

/** ������������ */

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	/** ϵͳ���̶��� */
	private TrayItem trayItem;

	/** ϵͳ���̵�ͼ����� */
	private Image trayImage;

	/** ����Ĳ˵��� */
	private ApplicationActionBarAdvisor actionBarAdvisor;

	/** ���췽�� */
	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	/** �����˵������� */
	public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
		actionBarAdvisor = new ApplicationActionBarAdvisor(configurer);
		return actionBarAdvisor;
	}

	/** �򿪴���ǰ���ø÷������Դ��ڳ�ʼ������ */
	public void preWindowOpen() {
		/** ���ô��ڳ�ʼ���ĸ������� */
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setInitialSize(new Point(700, 550));
		configurer.setShowCoolBar(true);
		configurer.setShowStatusLine(false);
		configurer.setTitle("SuperCRM");
		configurer.setShowPerspectiveBar(true);
		configurer.setShowStatusLine(true);

		final IWorkbenchWindow window = getWindowConfigurer().getWindow();
		/** ����ϵͳ���� */
		trayItem = initTrayItem(window);
		/** ���֧��ϵͳ���̣��򴴽����̵Ĳ˵� */
		if (trayItem != null) {
			createPopupMenu(window);
		}

	}

	/**
	 * ����ϵͳ���̲˵�
	 * 
	 * @param window
	 *            ����̨���ڶ���
	 */
	private void createPopupMenu(final IWorkbenchWindow window) {
		trayItem.addListener(SWT.MenuDetect, new Listener() {
			public void handleEvent(Event event) {
				/** ͨ��MenuManager�����������˵� */
				MenuManager trayMenu = new MenuManager();
				Menu menu = trayMenu.createContextMenu(window.getShell());

				/**
				 * ����fillTrayItem��������ϵͳ���̶��󣬿���ֱ�����ò˵����еĲ��� ������Ҫ�����´�������
				 */
				actionBarAdvisor.fillTrayItem(trayMenu);
				menu.setVisible(true);
			}
		});

	}

	/**
	 * ��ʼ��ϵͳ���̶���
	 * 
	 * @param window
	 *            ����̨���ڶ���
	 * @return �ó�������Ӧ��ϵͳ���̶���
	 */
	private TrayItem initTrayItem(IWorkbenchWindow window) {
		final Tray tray = Display.getCurrent().getSystemTray();
		if (tray == null)
			return null;
		/** ����ϵͳ���̲�����ϵͳ���̵ĸ������� */
		TrayItem trayItem = new TrayItem(tray, SWT.NONE);
		trayImage = SuperCRMPlugin.getImageDescriptor("icons/logo.gif").createImage();
		trayItem.setImage(trayImage);
		trayItem.setToolTipText("SuperCRM");
		return trayItem;
	}

	/** �ͷŴ��ڣ��ͷ�ϵͳ���� */
	public void dispose() {
		if (trayImage != null) {
			trayImage.dispose();
			trayItem.dispose();
		}
	}

}
