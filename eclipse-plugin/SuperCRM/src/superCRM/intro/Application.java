package superCRM.intro;

import org.eclipse.core.runtime.IPlatformRunnable;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import superCRM.SuperCRMPlugin;
import superCRM.business.SuperContext;
import superCRM.dialog.LoginDialog;
import superCRM.preferences.PreferenceConstants;

/**
 * ����Ϊ������������
 */
public class Application implements IPlatformRunnable {

	/**
	 * IPlatformRunnable�ӿ��еķ���
	 * 
	 * @see org.eclipse.core.runtime.IPlatformRunnable#run(java.lang.Object)
	 */
	public Object run(Object args) throws Exception {
		Display display = PlatformUI.createDisplay();
		try {
		/**��õ�ǰ�û������¶���*/
			SuperContext context = SuperContext.getInstance();
		/**����login������֤�û�������û������벻��ȷ���˳�����*/
			if (!login(context))
				return IPlatformRunnable.EXIT_OK;
		/**��֤�ɹ��󣬴���ס���򴰿�*/
			int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
			if (returnCode == PlatformUI.RETURN_RESTART) {
				return IPlatformRunnable.EXIT_RESTART;
			}
			return IPlatformRunnable.EXIT_OK;
		} finally {
			display.dispose();
		}
	}
	/**
	 * �ж��û��Ƿ��ѵ�¼
	 * 
	 * @param context �����¼��Ϣ�������Ķ���
	 * @return true��ʾ�Ѿ���¼
	 */
	private boolean login(SuperContext context) {
		/**�����ѡ���жԵ�¼������*/
		IPreferenceStore store = SuperCRMPlugin.getDefault().getPreferenceStore();
		
		/**�����ѡ������Ϊ�Զ���½������Ҫ��¼*/
		if ( store.getBoolean(PreferenceConstants.P_AUTO_LOGIN)){
			context.setLogin( true );
		/**���򣬵�����½�Ի���*/
		}else {
			LoginDialog loginDialog = new LoginDialog(null);
		/**�����������ȷ���û��������룬�����õ�½�ɹ�*/
			if (loginDialog.open() == Window.OK)
				context.setLogin(true);		
		}
		return context.isLogin();
	}
}
