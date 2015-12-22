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

import superCRM.model.ICustomerSerivce;
import superCRM.model.SuperFactory;
import superCRM.pojos.CustomerEO;

public class QuickNewCustomerView extends ViewPart {
	public static final String ID = "superCRM.views.QuickNewCustomerView";

	/** �ͻ����� */
	private Text displayName;

	/** ��ַ */
	private Text website;

	/** �ͻ����� */
	private Combo category;

	/** ��˾���� */
	private Combo number;

	public QuickNewCustomerView() {
		super();
	}

	/** ������ͼ�Ľ��� */
	public void createPartControl(Composite parent) {
		/** ������岼�� */
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		/** �ͻ����� */
		new Label(composite, SWT.NONE).setText("�ͻ����ƣ�");
		displayName = new Text(composite, SWT.BORDER);
		displayName.setLayoutData(data);
		/** ��ַ */
		new Label(composite, SWT.NONE).setText("��ַ��");
		website = new Text(composite, SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL);
		website.setLayoutData(data);
		/** �ͻ����� */
		new Label(composite, SWT.NONE).setText("���");
		category = new Combo(composite, SWT.BORDER);
		category.setItems(new String[] { "Customer", "Partener", "Competitor" });
		category.select(0);
		data = new GridData(GridData.FILL_HORIZONTAL);
		category.setLayoutData(data);
		/** ��˾���� */
		new Label(composite, SWT.NONE).setText("��˾������");
		number = new Combo(composite, SWT.BORDER);
		number.setItems(new String[] { "1-10", "11-50", "51-100", "101-500", "500-" });
		number.select(0);
		data = new GridData(GridData.FILL_HORIZONTAL);
		number.setLayoutData(data);
		/** ��Ӱ�ť */
		Button btAdd = new Button(composite, SWT.PUSH);
		btAdd.setText("���");
		/** ע����Ӱ�ť������ */
		btAdd.addSelectionListener(new SelectionAdapter() {
			/** ��������Ӱ�ťʱ */
			public void widgetSelected(SelectionEvent e) {
				/** �����ͻ����� */
				CustomerEO customer = new CustomerEO();
				/** �ֱ�ȡ���û�����ֵ,����ֵ���ͻ����� */
				customer.setDisplayName(displayName.getText());
				customer.setWebSite(website.getText());
				customer.setCategory(category.getText());
				customer.setNumberEmployee(number.getText());
				/** ����ҵ��㱣��ͻ����� */
				ICustomerSerivce customerSerivce = SuperFactory.getSuperApplication().getCustomerSerivce();
				customerSerivce.addCustomer(customer);
				/** �����Ƿ�ͻ��б���ͼ�Ѿ��� */
				IViewPart view = getViewSite().getPage().findView(CustomerSummaryView.ID);
				/** ��û��,�����ȴ򿪿ͻ��б���ͼ */
				if (view == null) {
					try {
						view = getViewSite().getPage().showView(CustomerSummaryView.ID);
					} catch (PartInitException ee) {
						ee.printStackTrace();
					}
				}
				/** ���¿ͻ��б����� */
				CustomerSummaryView customerSummaryView = (CustomerSummaryView) view;
				customerSummaryView.refreshData();
			}

		});

	}

	public void setFocus() {
		displayName.setFocus();
	}

}
