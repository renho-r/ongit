package superCRM.dialog;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchWindow;

import superCRM.model.IContactSerivce;
import superCRM.model.ICustomerSerivce;
import superCRM.model.SuperFactory;
import superCRM.pojos.ContactEO;
import superCRM.pojos.CustomerEO;

public class NewCustomerWizard extends Wizard {
	/** �½��ͻ�ҳ�� */
	private NewCustomerWizardPage newCustomerPage;

	/** �½���ϵ��ҳ�� */
	private NewContactWizardPage newContactPage;

	/** ���췽��,��ʼ��ҳ�� */
	public NewCustomerWizard(IWorkbenchWindow window) {
		newCustomerPage = new NewCustomerWizardPage();
		this.addPage(newCustomerPage);
		newContactPage = new NewContactWizardPage();
		this.addPage(newContactPage);
		this.setWindowTitle("�½��ͻ���");
	}

	/** ������ɰ�ťʱ */
	public boolean performFinish() {
		/** ����½��ͻ�ҳ������Ŀͻ����� */
		CustomerEO customer = newCustomerPage.getCustomer();
		/** ����ͻ�����Ϊnull */
		if (customer != null) {
			/** ����ҵ���,����ͻ������ݿ��� */
			ICustomerSerivce customerSerivce = SuperFactory.getSuperApplication().getCustomerSerivce();
			CustomerEO c = customerSerivce.addCustomer(customer);
			/** ����½���ϵ��ҳ�����ϵ�˶��� */
			ContactEO contact = newContactPage.getContact();
			/** �������Ϊ null ��ͻ�����Ϊnull */
			if (c == null || contact == null)
				return true;
			/** ����ҵ���,�������ϵ�˵����ݿ� */
			IContactSerivce contactSerivce = SuperFactory.getSuperApplication().getContactSerivce();
			contact.setCustomerId(c.getId());
			contactSerivce.addContact(contact);
		}
		return true;
	}

}
