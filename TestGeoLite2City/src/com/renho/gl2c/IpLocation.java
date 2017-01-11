package com.renho.gl2c;

public class IpLocation {
	
	private String ip;
	private String country;
	private String province;
	private String city;
	
	public IpLocation() {}
	
	public IpLocation(String ip) {
		this.ip = ip;
	}
	
	public IpLocation(String ip, String country, String province, String city) {
		this.ip = ip;
		this.country = country;
		this.province = province;
		this.city = city;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return this.country + " " + this.province + " " + this.city;
	}
}