package com.fengmanfei.ch19;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;

import com.fengmanfei.util.ImageFactory;

public class TableWindow extends ApplicationWindow {

	private TableViewer table;//����һ��������
	private  List persons ;//������洢������
	//������е�������
	public static final int ID = 0;
	public static final int NAME = 1;
	public static final int GENDER = 2;
	public static final int COLOR = 3;
	//������������
	public static final String[] COLUMN_NAME = { "ID��" ,"����","�Ա�","ϲ����ɫ"};
	public TableWindow() {
		super(null);
		initPersons();
	}

	//��ʼ��������ݣ�ͨ���Ǵ����ݿ��ж���
	private void initPersons() {
		persons = new ArrayList();
		persons.add( new PersonEO(1,"����","��","��ɫ"));
		persons.add( new PersonEO(2,"����","Ů","��ɫ"));
	}
	//���ô��ڵı���ʹ�С
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setSize(300, 200);
		shell.setText("TableViewer����ʾ��");
	}
	//�������ڵĿؼ�
	protected Control createContents(Composite parent) {
		//����TableViewer����
		table = new TableViewer(parent ,SWT.FULL_SELECTION);
		//table = CheckboxTableViewer.newCheckList( parent , SWT.FULL_SELECTION);
		//������ͷ
		for ( int i =0; i<COLUMN_NAME.length;i++){
			new TableColumn(table.getTable(), SWT.LEFT).setText(COLUMN_NAME[i]);
			table.getTable().getColumn(i).pack();
		}
		
		//����������
		table.setSorter( new TableSorter());
		//�ֱ�Ϊ��ͷ��ÿһ��ע���¼�
		TableColumn column = table.getTable().getColumn(0);
		column.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				//����ʱ���������������������
				((TableSorter)table.getSorter()).doSort(TableWindow.ID);
				//ˢ�±������
				table.refresh();
			}
		});
		column = table.getTable().getColumn(1);
		column.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				((TableSorter)table.getSorter()).doSort(TableWindow.NAME);
				table.refresh();
			}
		});
		column = table.getTable().getColumn(2);
		column.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				((TableSorter)table.getSorter()).doSort(TableWindow.GENDER);
				table.refresh();
			}
		});
		column = table.getTable().getColumn(3);
		column.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				((TableSorter)table.getSorter()).doSort(TableWindow.COLOR);
				table.refresh();
			}
		});
		//���ñ�ͷ�ͱ���߿ɼ�
	    table.getTable().setHeaderVisible(true);
	    table.getTable().setLinesVisible( true );
	    //��������
		table.setContentProvider(new MyContentProvider());
		//������ͼ
		table.setLabelProvider( new MyLabelProvider());
		//���ñ�����ݶ��󣬸÷����ǳ���Ҫ���Ǳ���������
		table.setInput(persons);
		createContextMenu();
		//����������
		table.setColumnProperties( COLUMN_NAME );

		//���õ�Ԫ��༭����������
	    CellEditor[] editors = new CellEditor[4];
	    editors[0] = null;
	    editors[1] = new TextCellEditor(table.getTable());
	    editors[2] = new TextCellEditor(table.getTable());
	    editors[3] = new TextCellEditor(table.getTable());
	    //���õ�Ԫ��༭��
	    table.setCellEditors(editors);
		//���õ�Ԫ���޸���
		table.setCellModifier( new ICellModifier(){
			
			//�������Ϊ��һ�У����ò����޸�
			public boolean canModify(Object element, String property) {
				if ( property.equals(COLUMN_NAME[0]))
					return false;
				return true;
			}
			//�����ڱ༭״̬ʱ����ʾ��ֵ
			public Object getValue(Object element, String property) {
				PersonEO p = (PersonEO) element;
				if ( property.equals(COLUMN_NAME[1]))
					return p.getName();
				else if ( property.equals(COLUMN_NAME[2]))
					return p.getGender();
				else if ( property.equals(COLUMN_NAME[3]))
					return p.getColor();
				return null;
			}
			//���޸ĺ����ø�������
			public void modify(Object element, String property, Object value) {
				if (element instanceof Item) 
					element = ((Item) element).getData();
				PersonEO p = (PersonEO) element;
				if ( property.equals(COLUMN_NAME[1]))
					p.setName( (String)value );
				else if ( property.equals(COLUMN_NAME[2]))
					p.setGender( (String)value );
				else if ( property.equals(COLUMN_NAME[3]))
					p.setColor( (String)value );
				//ˢ�±��
				table.refresh();
			}
			
		});

		table.addDoubleClickListener( new IDoubleClickListener(){
			public void doubleClick(DoubleClickEvent event) {
				StructuredSelection select = (StructuredSelection) event.getSelection();
				PersonEO p = (PersonEO) select.getFirstElement();
				System.out.println(p.getName());
			}
			
		} );
		return parent;
	}
	
	//���������Ĳ˵�
	private void createContextMenu() {
		MenuManager menu = new MenuManager();
		menu.add( new AddAction() );
		menu.add( new DelAction() );
		//menu.add( new FileterAction() );
		//���һ��Menu����
		Menu m = menu.createContextMenu(getShell());
		//���ö�������Ϊ���Ĳ˵�
		table.getTable().setMenu( m );
	}
	
	public static void main(String[] args) {
		TableWindow test = new TableWindow();
		test.setBlockOnOpen(true);
		test.open();
		Display.getCurrent().dispose();

	}
	public class MyContentProvider implements IStructuredContentProvider {

		//����ʼ�����ݵ���ڶ���ת���ɱ��ʹ�õ��������
		public Object[] getElements(Object inputElement) {
			if ( inputElement instanceof List )
				return ((List) inputElement).toArray();
			return null;
		}
		//�ͷŸö���ʱ���õķ���
		public void dispose() {

		}
		//������е����ݸı�ʱ���ø÷���
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

	}

	public class MyLabelProvider implements ITableLabelProvider {
		
		//����ÿ����Ԫ������ʾ��ͼ��
		public Image getColumnImage(Object element, int columnIndex) {
			/*
			//������Ա����ڵ���
			if (columnIndex == GENDER){
				//����ת����element�������е�һ��
				PersonEO person = (PersonEO)element;
				//���ݲ�ͬ��ֵ���ò�ͬ��ͼ��
				if ( person.getGender().equals("��"))
					return ImageFactory.loadImage( Display.getCurrent(),ImageFactory.ICON_BOY);
				else if ( person.getGender().equals("Ů"))
					return ImageFactory.loadImage( Display.getCurrent(),ImageFactory.ICON_GIRL);
			}
			*/
			return null;
		}
		//����ÿ����Ԫ������ʾ������
		public String getColumnText(Object element, int columnIndex) {
			//����ת����element�������е�һ��
			PersonEO person = (PersonEO)element;
			if ( columnIndex == ID)//����ǵ�һ�С�
				return person.getID()+"";
			else if ( columnIndex == NAME)//����ǵڶ��С�
				return person.getName()+"";
			else if ( columnIndex == GENDER)//����ǵ����С�
				return person.getGender();
			else if ( columnIndex == COLOR)//����ǵ����С�
				return person.getColor()+"";
			return "";
		}
		//�ͷŶ���ʱ�ͷ�ͼ����Դ
		public void dispose() {
			ImageFactory.dispose();
		}
		//���·���Ϊ��ʵ��
		public void addListener(ILabelProviderListener listener) {

		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {

		}

	}
	public class AddAction extends Action{
		public AddAction(){
			setText("���");
		}

		public void run() {
			//�½�һ��ʵ�����
			PersonEO person = new PersonEO();
			person.setID( table.getTable().getItemCount()+1);
			person.setName("Janet");
			person.setGender("Ů");
			person.setColor("��ɫ");
			//���һ������
			table.add( person );
		}
		
	}
	public class DelAction extends Action{
		public DelAction(){
			setText("ɾ��");
		}

		public void run() {
			//��õ�ǰ����ѡ�е���
			StructuredSelection selection = (StructuredSelection) table.getSelection();
			//ע�⣬ͬʱѡ�еĿ����Ƕ��У����Ƿ��ص����������
			//�����������һ��Ԫ�أ�Ҳ����ֻ��ѡ��һ�е����
			PersonEO p= (PersonEO)selection.getFirstElement();
			//�ӱ���ɾ������
			table.remove(p);
		}
		
	}
	public class FileterAction extends Action{
		//����һ��ViewerFilter����
		ViewerFilter femaleFilter;
		public FileterAction(){
			//���ñ��⣬��ʽΪ��ѡ����ʽ
			super("ɸѡ",AS_CHECK_BOX);
			//�ڲ��ഴ���ö���
			femaleFilter = new ViewerFilter(){
				//��ʵ��ViewerFilter���еĳ��󷽷�
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					PersonEO p = (PersonEO)element;
					return p.getGender().equals("Ů");
				}		
			};
			//��ʼ��ʱ����Ϊȡ��ѡ��״̬
			this.setChecked(false);
		}

		public void run() {
			//�����ʱѡ�У���Ϊ������ù�����
			if (isChecked())
				table.addFilter(femaleFilter );
			else//�����Ƴ���������
				table.removeFilter(femaleFilter);
			//ˢ�±������
			table.refresh();
		}
	}

}
