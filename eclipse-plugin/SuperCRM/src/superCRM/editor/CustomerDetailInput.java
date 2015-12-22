package superCRM.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import superCRM.pojos.CustomerEO;
import superCRM.SuperCRMPlugin;

public class CustomerDetailInput implements IEditorInput {

	/** �û���������Ŀͻ���Ϣ */
	private CustomerEO customer;

	public CustomerDetailInput(CustomerEO c) {
		this.customer = c;
	}

	/** ����Ϊ�ӿ��еķ��� */
	public boolean exists() {
		return true;
	}

	public ImageDescriptor getImageDescriptor() {
		return SuperCRMPlugin.getImageDescriptor("icons/customer.gif");
	}

	public String getName() {
		return customer.getDisplayName();
	}

	public IPersistableElement getPersistable() {
		return null;
	}

	public String getToolTipText() {
		return customer.getDisplayName();
	}

	public Object getAdapter(Class adapter) {
		return null;
	}

	/** ��ÿͻ����� */
	public CustomerEO getCustomer() {
		return customer;
	}

	/** ���ÿͻ����� */
	public void setCustomer(CustomerEO customer) {
		this.customer = customer;
	}

}
