package superCRM.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import superCRM.model.IContactSerivce;
import superCRM.model.SuperFactory;
import superCRM.pojos.ContactEO;

public class QuickNewContactView extends ViewPart {
	/** ����ͼ��ID */
	public static final String ID = "superCRM.views.QuickNewContactView";

	/** ���� */
	private Text displayName;

	/** ��� */
	private Combo category;

	/** �Ա� */
	private Combo sex;

	public QuickNewContactView() {
		super();
	}

	public void createPartControl(Composite parent) {
		/** ������岼�� */
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		/** ���� */
		new Label(composite, SWT.NONE).setText("������");
		displayName = new Text(composite, SWT.BORDER);
		displayName.setLayoutData(data);
		/** ��� */
		new Label(composite, SWT.NONE).setText("���");
		category = new Combo(composite, SWT.BORDER);
		category.setItems(new String[] { "Friend", "Family", "Contact" });
		category.select(0);
		data = new GridData(GridData.FILL_HORIZONTAL);
		category.setLayoutData(data);
		/** �Ա� */
		new Label(composite, SWT.NONE).setText("�Ա�");
		sex = new Combo(composite, SWT.BORDER);
		sex.setItems(new String[] { "Female", "Male" });
		sex.select(0);
		data = new GridData(GridData.FILL_HORIZONTAL);
		sex.setLayoutData(data);
		/** ��Ӱ�ť */
		Button btAdd = new Button(composite, SWT.PUSH);
		btAdd.setText("���");
		btAdd.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				/** ������ϵ�˶��� */
				ContactEO contact = new ContactEO();
				/** �����������ϵ����Ϣ */
				contact.setDisplayName(displayName.getText());
				contact.setCategory(category.getText());
				contact.setSex(sex.getText());
				/** ����ҵ��㱣�浽���ݿ� */
				IContactSerivce contactSerivce = SuperFactory.getSuperApplication().getContactSerivce();
				contactSerivce.addContact(contact);
				/** ���ҵ�ǰҳ���Ƿ������ϵ���б���ͼ */
				IViewPart view = getViewSite().getPage().findView(ContactSummaryView.ID);
				/** ���δ����ϵ���б���ͼ,�����ͼ */
				if (view == null) {
					try {
						view = getViewSite().getPage().showView(ContactSummaryView.ID);
					} catch (PartInitException ee) {
						ee.printStackTrace();
					}
				}
				/** ������ϵ���б���ͼ */
				ContactSummaryView contactSummaryView = (ContactSummaryView) view;
				contactSummaryView.refreshData();
			}

		});
	}

	public void setFocus() {
		displayName.setFocus();

	}

}
