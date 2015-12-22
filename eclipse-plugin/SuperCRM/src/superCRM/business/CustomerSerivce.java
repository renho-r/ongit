package superCRM.business;

import java.util.List;
import superCRM.dao.DaoFactory;
import superCRM.dao.ICustomerDao;
import superCRM.model.ICustomerSerivce;
import superCRM.pojos.CustomerEO;

public class CustomerSerivce implements ICustomerSerivce {

	/** ���ݿ���ʵ� DAO,ͨ�����������ʵ�ֶ����ݿ�Ĳ��� */
	private ICustomerDao customerDao;

	/** ���췽�� */
	public CustomerSerivce() {

		/** ����һ��DaoFactory�������� */
		DaoFactory daoFacory = new DaoFactory();
		/** ͨ����������������һ��ICustomerDao���� */
		customerDao = daoFacory.getCustomerDao();
	}

	public CustomerEO addCustomer(CustomerEO customer) {
		/** ���һ���ͻ� */
		return customerDao.addCustomer(customer);
	}

	public CustomerEO getCustomer(int id) {
		/** ����ָ���ͻ� */
		return customerDao.findById(id);
	}

	public List getCustomers(String keywords) {

		/** ����ؼ���Ϊ�ջ���Ϊnull,�򷵻����еĿͻ� */
		if (keywords == null || keywords.equals(""))
			return getAllCustomers();
		/** ���ݹؼ��ֻ�ò�ѯ�ͻ���� */
		return customerDao.findBykeywords(keywords);
	}

	public List getAllCustomers() {
		/** ������еĿͻ� */
		return customerDao.getAllCustomers();
	}

	public void updateCustomer(CustomerEO customer) {
		/** ���¿ͻ� */
		customerDao.updateCustomer(customer);

	}

	public List getContacts(CustomerEO customer) {
		/** ��øÿͻ���������ϵ�� */
		return customerDao.getContacts(customer);
	}

}
