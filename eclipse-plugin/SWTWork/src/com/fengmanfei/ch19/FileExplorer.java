package com.fengmanfei.ch19;

import java.io.*;
import java.util.*;
import java.util.List;

import org.eclipse.jface.viewers.*;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.*;
import com.fengmanfei.util.ImageFactory;

public class FileExplorer extends ApplicationWindow {

	private SashForm sash;//�ָ��
	private TreeViewer tree;//��
	private TableViewer table;//���
	private OpenAction openAction;//�¼��������

	public FileExplorer() {
		super(null);
		openAction = new OpenAction();
	}
	//��ʼ����������
	protected Control createContents(Composite parent) {
		this.getShell().setText("���ļ������");
		this.getShell().setMaximized(true);
		sash = new SashForm(parent, SWT.SMOOTH);
		sash.setLayoutData(new GridData(GridData.FILL_BOTH));
		initTree();//��ʼ����
		initTable();//��ʼ�����
		sash.setWeights(new int[] { 40, 60 });
		return parent;
	}
	//��ʼ�����
	private void initTable() {
		table = new TableViewer(sash);
		//������ͷ
		new TableColumn(table.getTable(), SWT.LEFT).setText("����");
		new TableColumn(table.getTable(), SWT.LEFT).setText("����");
		new TableColumn(table.getTable(), SWT.LEFT).setText("��С");
		new TableColumn(table.getTable(), SWT.LEFT).setText("�޸�����");
		for (int i = 0; i < table.getTable().getColumnCount(); i++) {
			table.getTable().getColumn(i).pack();
		}
		//���ñ�ͷ�������߿ɼ�
		table.getTable().setHeaderVisible(true);
		table.getTable().setLinesVisible(true);
		//���ñ�������ṩ��
		table.setContentProvider(new FileTableContentProvider());
		//���ñ���ǩ�ṩ��
		table.setLabelProvider(new FileTableLabelProvider());
		//�����������
		table.setSorter(new FileSorter());
		//ע��˫���¼�
		table.addDoubleClickListener(openAction);

	}
	//��ʼ����
	private void initTree() {
		tree = new TreeViewer(sash);
		//�����������ṩ��
		tree.setContentProvider(new FileTreeContentProvider());
		//��������ǩ�ṩ��
		tree.setLabelProvider(new FileTreeLabelProvider());
		//��������ʼ�������ݣ�����û���κ�����
		//ʹ�õ��Ǹ�Ŀ¼�������������ṩ����
		tree.setInput("root");
		//ע����ѡ���¼�
		tree.addSelectionChangedListener(openAction);
	};

	public static void main(String[] args) {
		FileExplorer test = new FileExplorer();
		test.setBlockOnOpen(true);
		test.open();
		Display.getCurrent().dispose();
	}

	public class FileTreeContentProvider implements ITreeContentProvider {

		public Object[] getChildren(Object element) {
			//���˺�ֻ��ʾ�ļ���
			return ((File) element).listFiles(new AllowOnlyFoldersFilter());
		}

		public Object[] getElements(Object element) {
			File[] roots = File.listRoots();//��ø�Ŀ¼���ļ�
			List rootFolders = new ArrayList();
			//���˸�Ŀ¼��ֻ��ʾ��Ŀ¼�е��ļ���
			for (int i = 0; i < roots.length; i++) {
				if (roots[i].isDirectory())
					rootFolders.add(roots[i]);
			}
			return rootFolders.toArray();
		}

		public boolean hasChildren(Object element) {
			Object[] obj = getChildren(element);
			return obj == null ? false : obj.length > 0;
		}

		public Object getParent(Object element) {
			return ((File) element).getParentFile();
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

	}

	public class FileTreeLabelProvider implements ILabelProvider {

		public Image getImage(Object element) {
			File file = (File) element;
			if (file.isDirectory())
				return ImageFactory.loadImage(Display.getCurrent(),ImageFactory.FOLDER);
			return ImageFactory.loadImage(Display.getCurrent(),ImageFactory.FILE);
		}

		public String getText(Object element) {
			//���ڸ�Ŀ¼�е��ļ��У�û�����ƣ���ʱҪ��ʾ·��
			String text = ((File) element).getName();
			if (text.length() == 0) {
				text = ((File) element).getPath();
			}
			return text;
		}

		public void addListener(ILabelProviderListener listener) {	}

		public void dispose() {
			ImageFactory.dispose();
		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {}

	}

	class FileTableContentProvider implements IStructuredContentProvider {

		public void dispose() {}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

		public Object[] getElements(Object inputElement) {
			File file = (File) inputElement;
			return file.listFiles();
		}

	}

	class FileTableLabelProvider implements ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			File file = (File) element;
			if (columnIndex == 0) {
				if (file.isDirectory())
					return ImageFactory.loadImage(Display.getCurrent(),ImageFactory.FOLDER);
				else
					return ImageFactory.loadImage(Display.getCurrent(),ImageFactory.FILE);
			}
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			File file = (File) element;
			if (columnIndex == 0 )
				return file.getName();//��ʾ�ļ�����
			else if (columnIndex == 1) {
				//��ʾ�ļ�����
				if (file.isDirectory())
					return "�ļ���";
				else
					return "�ļ�";
			} else if (columnIndex == 2) {
				//������ļ��У���û�д�С
				if (file.isDirectory())
					return "";
				else
					return file.length() + " KB";
			} else if (columnIndex == 3) {
				//��ʾ����
				Date date = new Date(file.lastModified());
				return date.toLocaleString();
			}
			return null;
		}

		public void addListener(ILabelProviderListener listener) {}

		public void dispose() {
			ImageFactory.dispose();
		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {}

	}

	public class AllowOnlyFoldersFilter implements FileFilter {
		public boolean accept(File pathname) {
			return pathname.isDirectory();
		}

	}

	public class FileSorter extends ViewerSorter {
		public int category(Object element) {
			return ((File) element).isDirectory() ? 0 : 1;
		}
	}

	public class OpenAction implements ISelectionChangedListener, IDoubleClickListener {
		
		//ѡ������һ���ڵ�ʱ����������¼�
		public void selectionChanged(SelectionChangedEvent event) {
			table.setInput(getTreeSelection());
		}
		//˫�������һ��ʱ
		public void doubleClick(DoubleClickEvent event) {
			Object selection =  getTableSelection();
			if  (selection==null)
				return;
			File file = (File) selection;
			if (file.isFile()) {
				//������ļ����򿪸��ļ�
				Program.launch(file.getAbsolutePath());
			} else if (file.isDirectory()) {
				//������ļ��У��ڱ���д��ļ���
				table.setInput( selection );
			}
			
		}
	}
	//��õ�ǰ��ѡ�е���
	public Object getTreeSelection(){
		IStructuredSelection selection = (IStructuredSelection) tree.getSelection();
		if (selection.size() != 1)
			return null;
		return selection.getFirstElement();
	}
	//��õ�ǰ���ѡ�е���
	public Object getTableSelection(){
		IStructuredSelection selection = (IStructuredSelection) table.getSelection();
		if (selection.size() != 1)
			return null;
		return selection.getFirstElement();
	}
}
