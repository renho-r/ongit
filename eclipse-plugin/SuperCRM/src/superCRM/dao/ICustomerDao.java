package superCRM.dao;

import java.util.List;
import superCRM.pojos.CustomerEO;

/** �ͻ����ݿ����DAO */
public interface ICustomerDao {

	/** �ͻ����ݿ����DAO */
	public CustomerEO findById(int id);

	/** ���ݹؼ��ֲ��һ�ò�ѯ��� */
	public List findBykeywords(String keywords);

	/** ������еĿͻ���¼ */
	public List getAllCustomers();

	/** ��øÿͻ�����ϵ�� */
	public List getContacts(CustomerEO customer);

	/** ����sql����ÿͻ���¼ */
	public List getCustomerResult(String sql);

	/** ��ӿͻ� */
	public CustomerEO addCustomer(CustomerEO c);

	/** ���¿ͻ� */
	public void updateCustomer(CustomerEO c);
}
