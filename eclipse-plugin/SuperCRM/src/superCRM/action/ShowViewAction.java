package superCRM.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.views.IViewDescriptor;

public class ShowViewAction extends Action implements IWorkbenchAction {

	private IWorkbenchWindow workbenchWindow;

	private IViewDescriptor desc;

	public ShowViewAction(IWorkbenchWindow window, IViewDescriptor desc) {
		super("");
		/** �����ͼ������ */
		String label = desc.getLabel();
		/** ���ò��������� */
		setText(label);
		/** ���ò�����ͼ��Ϊ��ͼ��ͼ�� */
		setImageDescriptor(desc.getImageDescriptor());
		/** ���ò�������ʾ�ı� */
		setToolTipText(label);
		setId("ShowView" + desc.getId());
		this.workbenchWindow = window;
		this.desc = desc;
	}

	public void run() {
		/** ��õ�ǰ����������ù���ҳ�� */
		IWorkbenchPage page = workbenchWindow.getActivePage();
		/** ���ҳ�治Ϊnull */
		if (page != null) {
			try {
				/** ��ʾ��ͼ */
				page.showView(desc.getId());
			} catch (PartInitException e) {
				ErrorDialog.openError(workbenchWindow.getShell(), "����ͼ����", e.getMessage(), e.getStatus());
			}
		}
	}

	public void dispose() {
		workbenchWindow = null;

	}

}
