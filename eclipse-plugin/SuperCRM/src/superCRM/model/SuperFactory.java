package superCRM.model;

import superCRM.business.RcpApplication;

/**ͨ������ģʽ��������������ϵͳ�Ķ���*/
public class SuperFactory {
	
	/**����Ϊ˽������,������ʵ����*/
	private SuperFactory(){	}
	
	/**����Ϊ��̬����*/
	private static ISuperApplication app = null ;
	
	/**��ø�ʵ��*/
	public static ISuperApplication getSuperApplication (){
		if ( app == null){
			app = new RcpApplication();
		}
		return app;
	}
}
