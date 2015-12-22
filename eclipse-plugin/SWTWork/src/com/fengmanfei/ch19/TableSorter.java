package com.fengmanfei.ch19;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

public class TableSorter extends ViewerSorter {
	private static final int ASCENDING = 0;
	private static final int DESCENDING = 1;
	
	private int order;//�ж��������ǽ���
	private int column;//�ж��������

	public void doSort(int column) {
		// �����ͬһ�У��ı����е�˳��
		if (column == this.column) {
			order = 1 - order;
		} else {// �������һ�У���Ĭ��Ϊ��������
			this.column = column;
			order = ASCENDING;
		}
	}
	//���Ǹ���ķ��������رȽϽ����-1,0,1�������
	public int compare(Viewer viewer, Object e1, Object e2) {
		int result = 0;

		PersonEO p1 = (PersonEO) e1;
		PersonEO p2 = (PersonEO) e2;
		
		//Ĭ��������
		switch (column) {
		case TableWindow.ID:
			result = p1.getID() > p2.getID() ? 1 : -1;
			break;
		case TableWindow.NAME:
			result = collator.compare(p1.getName(), p2.getName());
			break;
		case TableWindow.GENDER:
			result = collator.compare(p1.getGender(), p2.getGender());
			break;
		case TableWindow.COLOR:
			result = collator.compare(p1.getColor(), p2.getColor());
			break;
		}
		//�����ʱΪ����
		if (order == DESCENDING)
			result = -result;
		return result;
	}
}
