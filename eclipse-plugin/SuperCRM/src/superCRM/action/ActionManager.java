package superCRM.action;

import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.views.IViewDescriptor;

public class ActionManager {

	/** �½��ͻ����� */
	public static IWorkbenchAction createNewCustomerAction(IWorkbenchWindow window) {
		if (window == null) {
			throw new IllegalArgumentException();
		}
		IWorkbenchAction action = new NewCustomerAction(window);
		return action;
	}

	/** �½���ϵ�˲��� */
	public static IWorkbenchAction createNewContactAction(IWorkbenchWindow window) {
		if (window == null) {
			throw new IllegalArgumentException();
		}
		IWorkbenchAction action = new NewContactAction(window);
		return action;
	}
	/**����ͼ���� */
	public static IWorkbenchAction createShowViewAction(IWorkbenchWindow window, String viewId) {
		if (window == null) {
			throw new IllegalArgumentException();
		}
		/**���plugin.xml�ļ������õ���ͼ��Ϣ*/
		IViewDescriptor desc = window.getWorkbench().getViewRegistry().find(viewId);
		IWorkbenchAction action = new ShowViewAction(window, desc);
		return action;
	}
}
