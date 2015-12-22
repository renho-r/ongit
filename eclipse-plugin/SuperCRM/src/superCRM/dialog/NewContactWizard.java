package superCRM.dialog;

import org.eclipse.jface.wizard.Wizard;

import superCRM.model.IContactSerivce;
import superCRM.model.SuperFactory;
import superCRM.pojos.ContactEO;
import superCRM.pojos.CustomerEO;

public class NewContactWizard extends Wizard {
	/** ѡ��ͻ�ҳ�� */
	private SelectCustomerPage selectCustomerPage;

	/** �½���ϵ��ҳ�� */
	private NewContactWizardPage newContactPage;

	/** ���췽��,��ʼ��ҳ�� */
	public NewContactWizard() {
		selectCustomerPage = new SelectCustomerPage();
		this.addPage(selectCustomerPage);
		newContactPage = new NewContactWizardPage();
		this.addPage(newContactPage);
		this.setWindowTitle("�½���ϵ����");
	}

	/** ������ɰ�ťʱ */
	public boolean performFinish() {
		/** ����½���ϵ��ҳ�����ϵ�˶��� */
		ContactEO contact = newContactPage.getContact();
		/** �����ϵ�˶���Ϊnull */
		if (contact == null)
			return true;
		/** ���ѡ��ͻ�ҳ����ѡ��Ŀͻ����� */
		CustomerEO customer = selectCustomerPage.getCusotmer();
		/** ������ϵ�˵Ŀͻ�ID */
		contact.setCustomerId(customer.getId());
		/** ����ҵ���,������ϵ����Ϣ */
		IContactSerivce contactSerivce = SuperFactory.getSuperApplication().getContactSerivce();
		contactSerivce.addContact(contact);
		return true;
	}

}
