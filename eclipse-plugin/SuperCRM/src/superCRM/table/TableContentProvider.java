package superCRM.table;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TableContentProvider implements IStructuredContentProvider {

	public Object[] getElements(Object inputElement) {
		/** ����������List���� */
		if (inputElement instanceof List) {
			List list = (List) inputElement;
			return list.toArray();
		}
		return null;
	}

	public void dispose() {

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

}
