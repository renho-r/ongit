package superCRM.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.part.EditorPart;

import superCRM.model.ICustomerSerivce;
import superCRM.model.SuperFactory;
import superCRM.pojos.CustomerEO;
import superCRM.views.CustomerSummaryView;

public class CustomerDetailEditor extends EditorPart {
	/** �༭����ID */
	public static final String ID = "superCRM.editor.CustomerDetailEditor";

	/** �༭���Ƿ��޸Ĺ��ı�� */
	private boolean bDirty = false;

	/** �༭������Ŀͻ����� */
	private CustomerEO customer;

	/** ����ؼ� */
	private Text displayName;

	private Text website;

	private Combo category;

	private Combo number;

	/** �����߶��� */
	private FormToolkit toolkit;

	public CustomerDetailEditor() {
		super();
	}

	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		this.setSite(site);
		this.setInput(input);
		this.setPartName(input.getName());
		/** ������ı༭������Ŀͻ�����ֵ���ͻ����� */
		this.customer = ((CustomerDetailInput) input).getCustomer();
	}

	public void createPartControl(Composite parent) {
		/** ���ñ굥�Ļ������� */
		toolkit = new FormToolkit(parent.getDisplay());
		ScrolledForm form = toolkit.createScrolledForm(parent);
		TableWrapLayout tableLayout = new TableWrapLayout();
		tableLayout.numColumns = 2;
		form.getBody().setLayout(tableLayout);
		form.setText("�ͻ���ϸ��Ϣ");
		toolkit.getColors().setForeground(form.getForeground());
		/** ��������Ŀؼ� */
		toolkit.createLabel(form.getBody(), "�ͻ�ID��");
		toolkit.createLabel(form.getBody(), customer.getId() + "");
		toolkit.createLabel(form.getBody(), "�ͻ����ƣ�");
		TableWrapData data = new TableWrapData(TableWrapData.FILL_GRAB);
		/** �ͻ����� */
		displayName = toolkit.createText(form.getBody(), customer.getDisplayName(), SWT.BORDER);
		displayName.setLayoutData(data);
		ModifyListener listener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (!isDirty()) {
					bDirty = true;
					firePropertyChange(IEditorPart.PROP_DIRTY);
				}
			}
		};
		displayName.addModifyListener(listener);

		/** ��ַ */
		toolkit.createLabel(form.getBody(), "��ַ��");
		data = new TableWrapData(TableWrapData.FILL_GRAB);
		website = toolkit.createText(form.getBody(), customer.getWebSite(), SWT.BORDER);
		website.setLayoutData(data);
		website.addModifyListener(listener);

		/** ��� */
		toolkit.createLabel(form.getBody(), "���");
		data = new TableWrapData(TableWrapData.FILL_GRAB);
		category = new Combo(form.getBody(), SWT.BORDER);
		toolkit.adapt(category, false, false);
		category.setItems(new String[] { "Customer", "Partener", "Competitor" });
		category.setLayoutData(data);
		category.setText(customer.getCategory());
		category.addModifyListener(listener);

		/** ��˾���� */
		toolkit.createLabel(form.getBody(), "��˾������");
		data = new TableWrapData(TableWrapData.FILL_GRAB);
		number = new Combo(form.getBody(), SWT.BORDER);
		toolkit.adapt(number, false, false);
		number.setItems(new String[] { "1-10", "11-50", "51-100", "101-500", "500-" });
		number.setLayoutData(data);
		number.setText(customer.getNumberEmployee());
		number.addModifyListener(listener);
	}

	/** ����༭�� */
	public void doSave(IProgressMonitor monitor) {
		try {
			monitor.beginTask("����ͻ�...", 100);
			/** ����޸ĺ�Ŀͻ���Ϣ */
			customer.setDisplayName(displayName.getText());
			customer.setWebSite(website.getText());
			customer.setCategory(category.getText());
			customer.setNumberEmployee(number.getText());
			/** ����ҵ��㱣����¿ͻ���Ϣ */
			ICustomerSerivce customerSerivce = SuperFactory.getSuperApplication().getCustomerSerivce();
			customerSerivce.updateCustomer(customer);
			/** ���¿ͻ��б���ͼ���� */
			refreshView();
			monitor.done();
			if (monitor.isCanceled())
				throw new InterruptedException("ȡ������");
		} catch (InterruptedException e) {
			;
		}
	}

	public void doSaveAs() {

	}

	public boolean isDirty() {
		return bDirty;
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

	public void setFocus() {
		displayName.setFocus();
	}

	/** ���¿ͻ��б���ͼ���� */
	public void refreshView() {
		IViewPart view = getEditorSite().getPage().findView(CustomerSummaryView.ID);
		if (view == null)
			return;
		CustomerSummaryView customerSummaryView = (CustomerSummaryView) view;
		customerSummaryView.refreshData();
	}
}
