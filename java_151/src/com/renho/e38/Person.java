package com.renho.e38;

/**
 *
 * @author Phenix
 * 2011-3-24
 */
public class Person{
	//����
	private String name;
	//��ͥ
	private Home home;
	//���캯����������ֵ
	public Person(String _name){
		name = _name;
	}

	public String getName() {
		return name;
	}
	public void setName(String _name) {
		name = _name;
	}
	public Home getHome() {
		return home;
	}
	public void setHome(Home home) {
		this.home = home;
	}

	public static class Home{
		//��ͥ��ַ
		private String address;
		//��ͥ�绰
		private String tel;
		
		public Home(String _address,String _tel){
			address = _address;
			tel = _tel;
		}
		
		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		
		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}		
	}
}

