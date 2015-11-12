package superCRM.intro;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import superCRM.views.ContactSummaryView;
import superCRM.views.CustomerSummaryView;
import superCRM.views.NavView;
import superCRM.views.QuickNewContactView;
import superCRM.views.QuickNewCustomerView;
import superCRM.views.SearchView;

;
/** Ĭ�ϵ�͸��ͼ�� */
public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();

		/** �༭���������õ�����ͼ */
		layout.addView(NavView.ID, IPageLayout.LEFT, 0.25f, editorArea);

		/** ������ͼ���·�����һЩ������ͼ�����ļ��е���ʽ */
		IFolderLayout leftBottom = layout.createFolder("left", IPageLayout.BOTTOM, 0.6f, NavView.ID);
		
		/** ������ͼ */
		leftBottom.addView(SearchView.ID);
		
		/** �����½���ϵ����ͼ */
		leftBottom.addView(QuickNewContactView.ID);
		
		/** �����½��ͻ���ͼ */
		leftBottom.addView(QuickNewCustomerView.ID);
		
		/** �༭�����Ϸ����ÿͻ��б���ͼ */
		layout.addView(CustomerSummaryView.ID, IPageLayout.TOP, 0.25f, editorArea);
		
		/** �༭�����Ϸ�Ԥ��������ϵ���б���ͼ */
		layout.addPlaceholder(ContactSummaryView.ID, IPageLayout.TOP, 0.25f, editorArea);
	}
}
