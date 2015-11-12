package superCRM.views;

import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import superCRM.SuperCRMPlugin;
import superCRM.preferences.PreferenceConstants;
import superCRM.model.IContactSerivce;
import superCRM.model.ICustomerSerivce;
import superCRM.model.SuperFactory;

public class SearchView extends ViewPart {
	/** ����ͼ��ID */
	public static final String ID = "superCRM.views.SearchView";

	/** �ͻ���ѡ��ť */
	private Button btCustomer;

	/** ��ϵ�˵�ѡ��ť */
	private Button btContact;

	/** �ؼ����ı� */
	private Text keywords;

	public SearchView() {
		super();
	}

	public void createPartControl(Composite parent) {
		/** ������岼�� */
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		/** ��������������������ѡ��ť */
		Group group = new Group(composite, SWT.NONE);
		group.setText("�������");
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(data);
		/** �ͻ���ѡ��ť */
		btCustomer = new Button(group, SWT.RADIO);
		btCustomer.setText("�ͻ�");
		/** ��ϵ�˵�ѡ��ť */
		btContact = new Button(group, SWT.RADIO);
		btContact.setText("��ϵ��");
		/** ������ѡ������Ĭ��ѡ�пͻ�����ѡ����ϵ�� */
		IPreferenceStore store = SuperCRMPlugin.getDefault().getPreferenceStore();
		String type = store.getString(PreferenceConstants.P_DEFAULT_SEARCH);
		if (type.equals("Customer"))
			btCustomer.setSelection(true);
		else
			btContact.setSelection(true);
		/** �ؼ��� */
		new Label(composite, SWT.NONE).setText("�ؼ��֣�");
		keywords = new Text(composite, SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL);
		keywords.setLayoutData(data);
		/** ������ť */
		Button btSearch = new Button(composite, SWT.PUSH);
		btSearch.setText("����");
		/** ������ѡ�а�ťʱ */
		btSearch.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				doSearch();
			}

		});
	}

	/** ִ������ */
	protected void doSearch() {
		/** ���ѡ���˿ͻ� */
		if (btCustomer.getSelection()) {
			/** ��ÿͻ�������� */
			ICustomerSerivce customerSerivce = SuperFactory.getSuperApplication().getCustomerSerivce();
			/** ��ò�ѯ����Ŀͻ����� */
			List customers = customerSerivce.getCustomers(keywords.getText());
			/** �򿪿ͻ��б���ͼ,��ˢ������ */
			IViewPart view = getViewSite().getPage().findView(CustomerSummaryView.ID);
			if (view == null) {
				try {
					view = getViewSite().getPage().showView(CustomerSummaryView.ID);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
			CustomerSummaryView customerSummaryView = (CustomerSummaryView) view;
			customerSummaryView.setData(customers);
			/** ���ѡ������ϵ�� */
		} else if (btContact.getSelection()) {
			/** �����ϵ�˷������ */
			IContactSerivce contactSerivce = SuperFactory.getSuperApplication().getContactSerivce();
			/** ��ò�ѯ�������ϵ������ */
			List contacts = contactSerivce.getContacts(keywords.getText());
			/** ����ϵ���б���ͼ,��ˢ������ */
			IViewPart view = getViewSite().getPage().findView(ContactSummaryView.ID);
			if (view == null) {
				try {
					view = getViewSite().getPage().showView(ContactSummaryView.ID);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
			ContactSummaryView contactSummaryView = (ContactSummaryView) view;
			contactSummaryView.setData(contacts);

		}
	}

	public void setFocus() {
		keywords.setFocus();
	}

}
