package com.renho.gl2c;

import java.io.IOException;

import com.maxmind.geoip2.exception.GeoIp2Exception;

public class Test {

	@org.junit.Test
	public void test() throws IOException, GeoIp2Exception{
		System.out.println(GeoLite2CityUtil.getSubdivision("60.16.10.0"));
		System.out.println(GeoLite2CityUtil.getSubdivision("49.112.0.0"));
		System.out.println(GeoLite2CityUtil.getSubdivision("65.64.214.0"));
		System.out.println(GeoLite2CityUtil.getSubdivision("78.51.212.0"));
		System.out.println(GeoLite2CityUtil.getSubdivision("220.181.108.146"));
		
		System.out.println(GeoLite2CityUtil.getLocation("60.16.10.0"));
		System.out.println(GeoLite2CityUtil.getLocation("49.112.0.0"));
		System.out.println(GeoLite2CityUtil.getLocation("65.64.214.0"));
		System.out.println(GeoLite2CityUtil.getLocation("78.51.212.0"));
		System.out.println(GeoLite2CityUtil.getLocation("220.181.108.146"));
		
		System.out.println(GeoLite2CityUtil.getSubdivision("10.0.0.1"));//AddressNotFoundException
	}

}
