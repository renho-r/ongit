package com.renho.e64.section2;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Client {

	public static void main(String[] args) {
		Integer[] data = {15,10,14,9,15};
		System.out.println(getSecond(data));		
	}

	
	public static int getSecond(Integer[] data){
		//ת��Ϊ�б�
		List<Integer> dataList = Arrays.asList(data);
		//ת��ΪTreeSet��ɾ���ظ�Ԫ��
		TreeSet<Integer> ts = new TreeSet<Integer>(dataList);
		//ȡ�ñ����ֵС�����ֵ��Ҳ�����϶���
		return ts.lower(ts.last());
	}
}
