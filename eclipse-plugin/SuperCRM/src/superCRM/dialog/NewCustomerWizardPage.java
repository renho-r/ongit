package superCRM.dialog;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import superCRM.pojos.CustomerEO;

;

public class NewCustomerWizardPage extends WizardPage {
	/** ҳ������ */
	public static final String NEW_CUSTOMER_PAGE = "CUSTOMER";

	/** �ͻ����� */
	private Text displayName;

	/** ��ַ */
	private Text website;

	/** �ͻ����� */
	private Combo category;

	/** ��˾���� */
	private Combo number;

	private CustomerEO customer;

	public NewCustomerWizardPage() {
		super(NEW_CUSTOMER_PAGE, "�½��ͻ�", null);
		this.setTitle("�½��ͻ�");
		this.setDescription("������ͻ�����ϸ��Ϣ��");
	}

	public void createControl(Composite parent) {
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
		setControl(composite);
	}

	/** ����û�����Ŀͻ���Ϣ */
	public CustomerEO getCustomer() {
		if (!displayName.getText().equals("")) {
			customer = new CustomerEO();
			customer.setDisplayName(displayName.getText());
			customer.setWebSite(website.getText());
			customer.setCategory(category.getText());
			customer.setNumberEmployee(number.getText());
		}
		return customer;
	}

}
