package superCRM.model;

import java.util.List;
import superCRM.pojos.ContactEO;

/**�йض���ϵ�˹���ķ���*/
public interface IContactSerivce {
	
	/**���һ����ϵ��*/
	public ContactEO addContact ( ContactEO contact );
	
	/**����ID�Ż�ø���ϵ�˵���Ϣ*/
	public ContactEO getContact ( int id );
	
	/**���ݹؼ��ֻ�ò�ѯ�ṹ����ϵ��*/
	public List getContacts ( String keywords );
	
	/**������е���ϵ��*/
	public List getAllContacts ();
}
