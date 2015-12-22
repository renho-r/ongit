package superCRM.model;

import java.util.List;
import superCRM.pojos.CustomerEO;

/**�йضԿͻ�����ķ���*/
public interface ICustomerSerivce {
	
	/**���һ���ͻ�*/
	public CustomerEO addCustomer ( CustomerEO customer );
	
	/**���¿ͻ���Ϣ*/
	public void updateCustomer ( CustomerEO customer );
	
	/**���ݿͻ�ID��ÿͻ���Ϣ*/
	public CustomerEO getCustomer ( int id );
	
	/**���ݹؼ��ֻ�ò�ѯ���Ŀͻ���Ϣ*/
	public List getCustomers ( String keywords );
	
	/**������пͻ���Ϣ*/
	public List getAllCustomers ();
	
	/**���ĳһ���ͻ��µ���ϵ��*/
	public List getContacts ( CustomerEO customer);
}
