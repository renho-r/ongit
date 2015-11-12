package superCRM.dialog;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import superCRM.pojos.ContactEO;

public class NewContactWizardPage extends WizardPage {
	/** ҳ������ */
	public static final String NEW_CONTACT_PAGE = "CONTACT";

	/** ���� */
	private Text displayName;

	/** ��� */
	private Combo category;

	/** �Ա� */
	private Combo sex;

	/** �������� */
	private Text birthDate;

	/** ְλ */
	private Combo jobTitle;

	/** ��ϵ�˶��� */
	private ContactEO contact;

	public NewContactWizardPage() {
		super(NEW_CONTACT_PAGE, "�½���ϵ��", null);
		this.setTitle("�½���ϵ��");
		this.setDescription("��������ϵ�˵���ϸ��Ϣ��");
	}

	public void createControl(Composite parent) {
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
		/** �������� */
		new Label(composite, SWT.NONE).setText("��������:");
		birthDate = new Text(composite, SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL);
		birthDate.setLayoutData(data);
		/** ְλ�� */
		new Label(composite, SWT.NONE).setText("ְλ��");
		jobTitle = new Combo(composite, SWT.BORDER);
		jobTitle.setItems(new String[] { "CEO", "CTO", "CFO" });
		jobTitle.select(0);
		data = new GridData(GridData.FILL_HORIZONTAL);
		jobTitle.setLayoutData(data);
		setControl(composite);
	}

	/** ����û��������ϵ����Ϣ */
	public ContactEO getContact() {
		if (!displayName.getText().equals("")) {
			contact = new ContactEO();
			contact.setDisplayName(displayName.getText());
			contact.setCategory(category.getText());
			contact.setSex(sex.getText());
			contact.setBirthDate(birthDate.getText());
			contact.setJobTitle(jobTitle.getText());
		}
		return contact;
	}

}
