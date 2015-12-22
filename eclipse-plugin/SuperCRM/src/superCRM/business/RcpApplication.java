package superCRM.business;

import superCRM.model.IContactSerivce;
import superCRM.model.ICustomerSerivce;
import superCRM.model.ISuperApplication;

public class RcpApplication implements ISuperApplication {

	/** ����ͻ�������� */
	private ICustomerSerivce customerSerivce = null;

	/** ������ϵ�˷������ */
	private IContactSerivce contactSerivce = null;

	/** ��ÿͻ�������� */
	public ICustomerSerivce getCustomerSerivce() {
		if (customerSerivce == null) {
			customerSerivce = new CustomerSerivce();
		}
		return customerSerivce;
	}

	/** �����ϵ�˷������ */
	public IContactSerivce getContactSerivce() {
		if (contactSerivce == null) {
			contactSerivce = new ContactSerivce();
		}
		return contactSerivce;
	}
}
