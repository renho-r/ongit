package superCRM.business;

public class SuperContext {

	/** ���췽��Ϊprivate */
	private SuperContext() {
	}

	/** ����ģʽ��Ӧ�� */
	private static SuperContext context = null;

	public static SuperContext getInstance() {
		if (context == null)
			context = new SuperContext();
		return context;
	}

	/** �����¼״̬���� */
	private boolean bLogin = false;

	/** �Ƿ��ѵ�¼ */
	public boolean isLogin() {
		return bLogin;
	}

	/** ���õ�¼״̬ */
	public void setLogin(boolean login) {
		bLogin = login;
	}

}
