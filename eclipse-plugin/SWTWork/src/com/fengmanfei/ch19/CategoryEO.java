package com.fengmanfei.ch19;

import java.util.ArrayList;
import java.util.List;

public class CategoryEO implements TreeElement{
	private String name ;
	private List lists ;//��������
	public CategoryEO( String name ){
		this.name = name ;
		lists = new ArrayList();
	}
	public String getName() {
		return name;
	}

	public boolean hasChildren() {
		if ( lists.size()>0)
			return true;
		return false;
	}

	public List getChildren() {
		return lists;
	}
	//����������ʹ���Ҳ����ʹ��Ʒ
	public void add(TreeElement element ) {
		lists.add( element );
	}

}
