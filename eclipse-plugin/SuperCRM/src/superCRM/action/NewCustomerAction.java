package superCRM.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

import superCRM.SuperCRMPlugin;
import superCRM.dialog.NewCustomerWizard;

public class NewCustomerAction extends Action implements IWorkbenchAction {
	/** ��������Ӧ��ID */
	public static final String ID = "superCRM.action.NewCustomerAction";

	private IWorkbenchWindow workbenchWindow;

	public NewCustomerAction(IWorkbenchWindow window) {
		if (window == null) {
			throw new IllegalArgumentException();
		}
		this.workbenchWindow = window;
		/** ����ID */
		setId(ID);
		setActionDefinitionId(ID);
		setText("�½��ͻ�");
		setImageDescriptor(SuperCRMPlugin.getImageDescriptor("icons/customer.gif"));
	}

	public void run() {
		if (workbenchWindow == null) {
			return;
		}
		/** ���½��ͻ��Ի��� */
		WizardDialog dlg = new WizardDialog(workbenchWindow.getShell(), new NewCustomerWizard(workbenchWindow));
		dlg.open();
	}

	public void dispose() {
		workbenchWindow = null;
	}

}
