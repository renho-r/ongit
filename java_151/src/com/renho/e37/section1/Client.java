package com.renho.e37.section1;


/**
 *
 * @author Phenix
 * 2011-3-17
 */
public class Client {
	public static void main(String[] args) {
		new Base();
		new Base("");
		new Base(0);
		System.out.println("ʵ������������" + Base.getNumOfObjects());
	}
}

class Base{
	private static int numOfObjects = 0;

	{
		//�������飬���������������
		numOfObjects++;
	}
		
	public Base(){
	}
	
	//�вι�������޲ι���
	public Base(String _str){		
		this();	
	}
	//�вι��첻������������
	public Base(int _i){
	}
	
	//������һ��JVM�У������˶��ٸ�ʵ������
	public static int getNumOfObjects(){
		return numOfObjects;
	}
}
